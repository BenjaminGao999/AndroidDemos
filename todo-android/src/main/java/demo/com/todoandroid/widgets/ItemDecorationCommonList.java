package demo.com.todoandroid.widgets;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import demo.com.todoandroid.App;
import demo.com.todoandroid.R;


/**
 * Author: benjamin
 * Time: 2018/6/23:上午11:26
 * email: benjamin.gaozq@gmail.com
 * desc: 任务列表， 条目间距
 */

public class ItemDecorationCommonList extends RecyclerView.ItemDecoration {

    private final int gapSize;

    public ItemDecorationCommonList() {
        super();
        Resources resources = App.getContext().getResources();
        float dimension = resources.getDimension(R.dimen.dimen_dp_10);
        gapSize = (int) (resources.getDisplayMetrics().density * dimension);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = gapSize;
    }


}
