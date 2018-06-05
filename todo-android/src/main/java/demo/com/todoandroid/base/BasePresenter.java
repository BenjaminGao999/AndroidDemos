package demo.com.todoandroid.base;

import android.content.Intent;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午11:39
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public interface BasePresenter<V extends BaseView> {

    void attach(V view);

    void detach();

    void onCreate();

    void passParams(Intent intent);

}
