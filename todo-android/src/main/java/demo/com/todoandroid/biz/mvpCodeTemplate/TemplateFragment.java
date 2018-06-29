package demo.com.todoandroid.biz.mvpCodeTemplate;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.com.todoandroid.BaseFragment;

/**
 * Author: benjamin
 * Time: 2018/6/11:上午10:33
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class TemplateFragment extends BaseFragment<TemplatePresenter> implements TemplateContract.View {


    @Override
    protected View goCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}
