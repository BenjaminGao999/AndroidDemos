package demo.com.todoandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: benjamin
 * Time: 2018/5/21:下午4:33
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView<P> {

    protected P mPresenter;

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return goCreateView(inflater, container, savedInstanceState);
    }


    protected abstract View goCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     * 当前view被销毁前调用
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 当前fragment不可用
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 当前fragment被activity移除前调用
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
