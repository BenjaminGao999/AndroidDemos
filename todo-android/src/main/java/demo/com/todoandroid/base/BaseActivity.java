package demo.com.todoandroid.base;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import demo.com.todoandroid.utils.ActivityUtils;
import demo.com.todoandroid.utils.InjectUtils;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午11:49
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment != null) {
            if (fragment instanceof BaseView) {
                BaseView view = (BaseView) fragment;
                if (view.getPresenter() == null) {
                    BasePresenter presenter = InjectUtils.inject(fragment, 0);
                    presenter.passParams(getIntent());
                    view.setPresenter(presenter);
                }

            }
        }
    }

    protected <V extends BaseView> V addFragment(Class<? extends BaseView> clz, @IdRes int resId, String tag) {
        BaseView fragment = (BaseView) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            try {
                fragment = clz.newInstance();
                ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), (android.support.v4.app.Fragment) fragment, resId, tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (V) fragment;
    }

}
