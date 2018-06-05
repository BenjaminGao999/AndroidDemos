package demo.com.todoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import demo.com.todoandroid.biz.postDetail.PostDetailActivity;

public class MainActivity extends AppCompatActivity {

    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;

        View cardViewGoPostDetail = findViewById(R.id.card_view_go_post_detail);


        cardViewGoPostDetail.setOnClickListener((View view) -> {
            Intent intent = new Intent(mainActivity, PostDetailActivity.class);
            startActivity(intent);
        });
    }
}
