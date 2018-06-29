package demo.com.todoandroid;

import android.app.Application;
import android.content.Context;

/**
 * Author: benjamin
 * Time: 2018/6/27:下午5:20
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class App extends Application {

    private static Context mContext;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        instance = this;
    }

    public static Context getContext() {
        return mContext;
    }

    public static App getInstance() {
        return instance;
    }
}

