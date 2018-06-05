package demo.com.todoandroid.biz.recyclerAdapter;

import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import demo.com.todoandroid.base.RecyclerViewAdapter;
import demo.com.todoandroid.biz.viewHolder.PinglunDianzanContainerViewHolder;
import demo.com.todoandroid.factory.ViewTypeFactory;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午10:31
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class PostDetailAdapter extends RecyclerViewAdapter {

    private final FragmentManager fragmentManager;

    public PostDetailAdapter(FragmentManager childFragmentManager) {
        fragmentManager = childFragmentManager;
    }

    @Override
    protected List<ViewType> onCreateViewTypes() {
        ArrayList<ViewType> list = new ArrayList<>();
        list.add(ViewTypeFactory.createPostContent());
        list.add(ViewTypeFactory.createPinglunDianzanContainer());
        return list;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // 拦截
        if (holder instanceof PinglunDianzanContainerViewHolder) {
            PinglunDianzanContainerViewHolder holder1 = (PinglunDianzanContainerViewHolder) holder;
            holder1.setmSupportFragmentManager(fragmentManager);
        }

        super.onBindViewHolder(holder, position);
    }
}
