package demo.com.todoandroid.biz.postDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import demo.com.todoandroid.R;
import demo.com.todoandroid.base.BaseActivity;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午9:46
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class PostDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Class<PostDetailFragment> clz = PostDetailFragment.class;
        addFragment(clz, R.id.rl_content, clz.getSimpleName());

    }
}
