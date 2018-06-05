package demo.com.postdetailapp.biz.postDetail;

import java.util.List;

import demo.com.postdetailapp.base.RecyclerViewAdapter;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午11:38
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public interface PostDetailContract {

    interface IView {

        //添加 recyclerView items
        void addItems(List<RecyclerViewAdapter.RecyclerItem> list);


    }


    interface IPresenter {


    }

}
