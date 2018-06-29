package demo.com.todoandroid.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;


import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import demo.com.todoandroid.App;
import demo.com.todoandroid.BuildConfig;
import demo.com.todoandroid.appStorage.SharePrefsConstants;
import demo.com.todoandroid.appStorage.SharePrefsHelper;
import demo.com.todoandroid.constants.Constants;
import demo.com.todoandroid.netApis.PartReqBody;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created : zzc
 * Time : 2017/5/15
 * Email : zzc1259@163.com
 * Description : ${网络请求通用参数工具}
 */

public class NetParamsUtils {
    public static final String TAG = NetParamsUtils.class.getSimpleName();
    private static Map<String, String> sMap = new TreeMap<>();

    static {
        sMap.put(Constants.NET_KEY_DEVICE_TYPE, Constants.PHONE_TYPE + "");
        sMap.put(Constants.NET_KEY_DEVICE_NAME, DeviceUtils.getManufacturer());
        sMap.put(Constants.NET_KEY_PHONE_MODEL, DeviceUtils.getModel());
        sMap.put(Constants.NET_KEY_SYSTEM_VERSION, Build.VERSION.RELEASE);
        sMap.put(Constants.NET_KEY_APP_VERSION, BuildConfig.VERSION_NAME);
        sMap.put(Constants.NET_KEY_DEVICE_ID, DeviceUtils.getDeviceId(App.getInstance()));
    }

    public static Map<String, String> getDeviceInfo() {
        return sMap;
    }

    /**
     * 表单请求统一加密
     *
     * @param request
     * @return
     */
    public static RequestBody createNewBody(Request request) {
        //---------------------------------------------common params , sign------------------------------------------
        Map<String, String> params = new TreeMap<>(sMap);
        params.put(Constants.NET_KEY_TIME_STAMP, TimeUtils.getCurTimeSeconds() + "");
        String loginToken = SharePrefsHelper.getInstance()
                .getString(SharePrefsConstants.LOGIN_TOKEN, "");
        params.put(Constants.NET_KEY_LOGIN_TOKEN, TextUtils.isEmpty(loginToken) ? "" : loginToken);

        RequestBody requestBody = request.body();
        if (requestBody instanceof MultipartBody) {
            MultipartBody body = (MultipartBody) requestBody;
            List<MultipartBody.Part> parts = body.parts();
            MultipartBody.Part part;
            RequestBody partBody;
            for (int i = 0; i < parts.size(); i++) {
                part = parts.get(i);
                partBody = getPartBody(part);
                if (partBody != null && partBody instanceof PartReqBody) {
                    params.put(((PartReqBody) partBody).getKey(), ((PartReqBody) partBody).getValue());
                }
            }
        } else if (requestBody instanceof FormBody) {
            FormBody body = (FormBody) request.body();
            for (int i = 0, len = body.size(); i < len; i++) {
                params.put(body.encodedName(i), body.encodedValue(i));
            }
        }
        sign(params);
        //---------------------------------------------create new Req body------------------------------------------
        RequestBody newBody;
        if (requestBody instanceof MultipartBody) {
            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            for (String key : params.keySet()) {
                builder.addFormDataPart(key, params.get(key));
            }
            List<MultipartBody.Part> parts = ((MultipartBody) requestBody).parts();
            for (int i = 0; i < parts.size(); i++) {
                builder.addPart(parts.get(i));
            }
            newBody = builder.build();
        } else {
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : params.keySet()) {
                builder.addEncoded(key, params.get(key));
            }
            newBody = builder.build();
        }
        return newBody;
    }

    private static RequestBody getPartBody(MultipartBody.Part part) {
        try {
            Field body = part.getClass().getDeclaredField("body");
            body.setAccessible(true);
            return (RequestBody) body.get(part);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void sign(Map<String, String> sortedParams) {
        StringBuilder sb = new StringBuilder();
        for (String key : sortedParams.keySet()) {
            sb.append(key).append("=").append(sortedParams.get(key)).append("&");
        }
        Logger.i("request params - " + sb.toString());
        String sign;
        try {
            String decorate = sb.append(UtilWrapper.decorate()).toString();
            decorate = URLDecoder.decode(decorate);
            sign = Md5Utils.md5Encode(decorate);
        } catch (Exception e) {
            sign = "xxx";
            LogUtils.e(e.toString());
        }
        sign = sign.substring(5, 15);
        sortedParams.put(Constants.NET_KEY_SIGN, sign);

        Log.i(TAG, "sign: sign --- "+sign);
    }
}
