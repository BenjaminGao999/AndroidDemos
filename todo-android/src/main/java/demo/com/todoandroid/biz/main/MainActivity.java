package demo.com.todoandroid.biz.main;

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
 * desc:
 */

@Route(path = RouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ActionBar mActionBar;
    private TextView mTvTitle;
    private ImageView ivNaviBack;
    private TextView tvCommit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_template);
        setUpToolbar();
        setToolbarTitle(R.string.title_mvp_template);
        initView();

        MainFragment fragment = new MainFragment();
        addFragmentToActivity(fragment, new MainPresenter(fragment), R.id.fl_content);
    }

    private void initView() {

        ivNaviBack.setOnClickListener(this);

        tvCommit.setOnClickListener(this);
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

        tvCommit = (TextView) findViewById(R.id.tv_commit);
        tvCommit.setVisibility(View.GONE);
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


            case R.id.tv_commit:



                break;

            default:
                break;
        }
    }
}
