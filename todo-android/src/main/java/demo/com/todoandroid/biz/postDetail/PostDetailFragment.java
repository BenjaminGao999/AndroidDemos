package demo.com.todoandroid.biz.postDetail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import demo.com.todoandroid.R;
import demo.com.todoandroid.base.BaseFragment;
import demo.com.todoandroid.base.RecyclerBaseFragment;
import demo.com.todoandroid.base.RecyclerViewAdapter;
import demo.com.todoandroid.biz.recyclerAdapter.PostDetailAdapter;
import demo.com.todoandroid.databinding.FragmentPostDetailBinding;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午11:38
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class PostDetailFragment extends RecyclerBaseFragment<PostDetailPresenter> implements PostDetailContract.IView {

    private FragmentPostDetailBinding mBinding;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_post_detail;
    }

    @Override
    protected void onInflated(BaseFragment<PostDetailPresenter> target, View inflate) {
        super.onInflated(target, inflate);
        mBinding = DataBindingUtil.bind(inflate);
        mBinding.recyclerViewContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerViewContent.setAdapter(mAdapter);

    }


    @Override
    protected RecyclerViewAdapter createAdapter() {
        return new PostDetailAdapter(getChildFragmentManager());
    }

    @Override
    public void addItems(List<RecyclerViewAdapter.RecyclerItem> list) {
        mAdapter.addRecyclerItemList(list);
    }
}
