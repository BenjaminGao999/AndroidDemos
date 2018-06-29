package demo.com.todoandroid.widgets;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Author: benjamin
 * Time: 2018/6/25:下午7:56
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class MyLinearLayoutManager extends LinearLayoutManager {


    public MyLinearLayoutManager(Context context) {
        super(context);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
