package demo.com.mydemos;

import android.app.Application;
import android.widget.Toast;

/**
 * Author: benjamin
 * Time: 2018/6/17:上午10:53
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // BuildConfig 系统自动生成
        if (BuildConfig.DEBUG) {
            Toast.makeText(this, "Debug "+true, Toast.LENGTH_SHORT).show();
        }

    }
}
