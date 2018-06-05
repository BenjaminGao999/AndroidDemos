package demo.com.postdetailapp.biz.postDetail;

import android.content.Intent;

import java.util.ArrayList;

import demo.com.postdetailapp.base.BasePresenter;
import demo.com.postdetailapp.base.RecyclerViewAdapter;
import demo.com.postdetailapp.factory.RecyclerItemFactory;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午11:47
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class PostDetailPresenter implements PostDetailContract.IPresenter,BasePresenter<PostDetailFragment> {


    private PostDetailFragment mView;

    @Override
    public void attach(PostDetailFragment view) {
        mView = view;
    }

    @Override
    public void detach() {

    }

    @Override
    public void onCreate() {
        ArrayList<RecyclerViewAdapter.RecyclerItem> items = new ArrayList<>();
        items.add(RecyclerItemFactory.createPostContentItem(null));
        items.add(RecyclerItemFactory.createPinglunDianzanContainerItem(null));
        mView.addItems(items);


    }

    @Override
    public void passParams(Intent intent) {

    }
}
