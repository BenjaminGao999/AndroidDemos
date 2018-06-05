package demo.com.todoandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: benjamin
 * Time: 2018/5/31:下午12:24
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView<P> {


    protected P mPresenter;

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutRes(), container, false);
        onInflated(this,inflate);
        initView(savedInstanceState, inflate);
        mPresenter.attach(this);
        return inflate;
    }


    protected abstract int getLayoutRes();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.onCreate();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detach();
    }

    protected abstract void onInflated(BaseFragment<P> target, View inflate);


    protected abstract void initView(Bundle savedInstanceState, View inflate);

}
