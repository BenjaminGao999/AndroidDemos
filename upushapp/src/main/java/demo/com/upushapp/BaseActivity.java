package demo.com.upushapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.message.PushAgent;

/**
 * Author: benjamin
 * Time: 2018/6/27:下午3:31
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PushAgent.getInstance(this).onAppStart();
    }
}
