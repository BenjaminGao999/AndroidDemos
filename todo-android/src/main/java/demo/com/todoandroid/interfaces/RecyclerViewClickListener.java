package demo.com.todoandroid.interfaces;

import android.view.View;

/**
 * Author: benjamin
 * Time: 2018/6/14:下午4:39
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public interface RecyclerViewClickListener<T> {

    void onClick(View view, T data);
}
