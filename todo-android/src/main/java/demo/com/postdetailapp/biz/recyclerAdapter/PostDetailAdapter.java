package demo.com.postdetailapp.biz.recyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import demo.com.postdetailapp.base.RecyclerViewAdapter;
import demo.com.postdetailapp.factory.ViewTypeFactory;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午10:31
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class PostDetailAdapter extends RecyclerViewAdapter {

    @Override
    protected List<ViewType> onCreateViewTypes() {
        ArrayList<ViewType> list = new ArrayList<>();
        list.add(ViewTypeFactory.createPostContent());
        list.add(ViewTypeFactory.createPinglunDianzanContainer());
        return list;
    }
}
