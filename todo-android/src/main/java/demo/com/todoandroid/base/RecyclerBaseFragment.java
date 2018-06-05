package demo.com.todoandroid.base;

import android.os.Bundle;
import android.view.View;

/**
 * Author: benjamin
 * Time: 2018/5/31:下午2:54
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public abstract class RecyclerBaseFragment<P extends BasePresenter> extends BaseFragment<P> {

    protected RecyclerViewAdapter mAdapter;

    @Override
    protected void onInflated(BaseFragment<P> target, View inflate) {
       mAdapter =  createAdapter();
    }

    protected abstract RecyclerViewAdapter createAdapter();

    @Override
    protected void initView(Bundle savedInstanceState, View inflate) {

    }


}
