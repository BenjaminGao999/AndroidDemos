package demo.com.todoandroid.interfaces;

import java.util.List;

/**
 * Author: benjamin
 * Time: 2018/6/14:下午4:06
 * email: benjamin.gaozq@gmail.com
 * desc: 处理列表数据的加载和刷新
 */

public interface RecyclerViewList<T> {

    void addData(List<T> data);

    void resetData(List<T> data);


    void setClickListener(RecyclerViewClickListener<T> listener);



}
