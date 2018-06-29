package demo.com.todoandroid.netApis;

import java.io.IOException;

import demo.com.todoandroid.App;
import demo.com.todoandroid.utils.NetParamsUtils;
import demo.com.todoandroid.utils.NetworkUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created : zzc
 * Time : 2017/5/2
 * Email : zzc1259@163.com
 * Description : ${网络参数与返回统一处理}
 */

public class OpInterceptor implements Interceptor {
    private static final String TAG = OpInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!NetworkUtils.isAvailable(App.getInstance())) {
            throw new NetException(0, "网络异常");
        }
        if ("GET".equals(chain.request().method())) {
            try {
                return chain.proceed(chain.request());
            } catch (Exception e) {
                throw new NetException(0, e.toString());
            }
        }
        RequestBody reqBody = NetParamsUtils.createNewBody(chain.request());
        Request request = chain.request().newBuilder().post(reqBody).build();

        Response response = chain.proceed(request);

        return response;
    }
}
