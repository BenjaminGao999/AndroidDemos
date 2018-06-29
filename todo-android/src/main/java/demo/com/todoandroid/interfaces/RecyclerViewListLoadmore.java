package demo.com.todoandroid.interfaces;

/**
 * Author: benjamin
 * Time: 2018/6/14:下午4:06
 * email: benjamin.gaozq@gmail.com
 * desc: loadmore
 */

public interface RecyclerViewListLoadmore<T> extends RecyclerViewList<T>{


    void setLoadmoreListener(RecyclerViewLoadmoreListener<T> loadmoreListener);

}
