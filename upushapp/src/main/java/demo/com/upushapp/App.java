package demo.com.upushapp;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Author: benjamin
 * Time: 2018/6/27:下午3:21
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class App extends Application {
    private static final String TAG = "App";
    private String UmengMessageSecret = "ef063c4731c893b6f4a41d77ce0781fa";

    @Override
    public void onCreate() {
        super.onCreate();

        initUmeng();

    }

    private void initUmeng() {
        UMConfigure.init(this,
                UMConfigure.DEVICE_TYPE_PHONE,
                UmengMessageSecret);

        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i(TAG, "onSuccess: deviceToken *** - " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.i(TAG, "onFailure: 注册失败，没有deviceToken");
            }
        });
    }


}
