package demo.com.todoandroid.aboutRecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import demo.com.todoandroid.BaseActivity;
import demo.com.todoandroid.R;
import demo.com.todoandroid.constants.RouterPath;


/**
 * Author: benjamin
 * Time: 2018/6/11:上午10:26
 * email: benjamin.gaozq@gmail.com
 * desc:  pullToRefresh recyclerView
 */

@Route(path = RouterPath.ACTIVITY_RECYCLER_VIEW_LIST)
public class RecycletViewActivity extends BaseActivity implements View.OnClickListener {

    private ActionBar mActionBar;
    private TextView mTvTitle;
    private ImageView ivNaviBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_list);
        setUpToolbar();
        setToolbarTitle(R.string.text_title);
        initView();

        RecyclerViewFragment fragment = new RecyclerViewFragment();
        RecyclerViewPresenter presenter = new RecyclerViewPresenter(fragment);
        addFragmentToActivity(fragment, presenter, R.id.fl_content);

    }

    private void initView() {

        ivNaviBack.setOnClickListener(this);
    }

    private void setUpToolbar() {
        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mActionBar = getSupportActionBar();
//        mActionBar.setDisplayHomeAsUpEnabled(true);
//        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        ivNaviBack = (ImageView) findViewById(R.id.iv_navigate_back);
    }

    private void setToolbarTitle(@Nullable int title) {
//        mActionBar.setTitle("");
        mTvTitle.setText(title);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_navigate_back:
                onBackPressed();
                break;

            default:
                break;
        }
    }
}
