package demo.com.todoandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Author: benjamin
 * Time: 2018/5/21:下午4:28
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.addActivity(this);


    }

    protected void addFragmentToActivity(@NonNull BaseView fragment, @NonNull BasePresenter presenter, int frameId) {
        fragment.setPresenter(presenter);
        getSupportFragmentManager()
                .beginTransaction()
                .add(frameId, (Fragment) fragment, fragment.getClass().getSimpleName())
                .commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.removeActivity(this);
    }
}
