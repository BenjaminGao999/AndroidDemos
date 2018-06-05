package demo.com.todoandroid.biz.viewHolder;


import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import demo.com.todoandroid.R;
import demo.com.todoandroid.base.RecyclerViewAdapter;
import demo.com.todoandroid.biz.viewPagerAdapter.VpAdapter;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午11:04
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class PinglunDianzanContainerViewHolder extends RecyclerViewAdapter.ViewHolder {


    private final ViewPager viewPager;
    private final TabLayout tablayout;
    private FragmentManager mSupportFragmentManager;

    public PinglunDianzanContainerViewHolder(View itemView) {
        super(itemView);
        viewPager = itemView.findViewById(R.id.vp);
        tablayout = itemView.findViewById(R.id.tb);
        tablayout.setupWithViewPager(viewPager);
    }

    public void setmSupportFragmentManager(FragmentManager mSupportFragmentManager) {
        this.mSupportFragmentManager = mSupportFragmentManager;
    }

    @Override
    protected void onBindData(Object data) {
        super.onBindData(data);
        viewPager.setAdapter(new VpAdapter(mSupportFragmentManager));
    }
}
