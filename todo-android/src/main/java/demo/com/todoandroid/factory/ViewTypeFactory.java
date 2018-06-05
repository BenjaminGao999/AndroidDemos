package demo.com.todoandroid.factory;

import demo.com.todoandroid.R;
import demo.com.todoandroid.base.RecyclerViewAdapter;
import demo.com.todoandroid.biz.viewHolder.PinglunDianzanContainerViewHolder;
import demo.com.todoandroid.biz.viewHolder.PostViewHolder;

/**
 * @auth zzc
 * @date 2018/1/8
 * @desc ${viewType工厂}
 * viewType包含3部分
 * <p>
 * viewType
 * <p>
 * layoutRes
 * <p>
 * viewHolder clazz
 */

public class ViewTypeFactory {
//    static final int VIEW_TYPE_DEFAULT = -1;
//    static final int VIEW_TYPE_EMPTY = 1;
//    static final int VIEW_TYPE_NO_MORE = 2;
//    static final int VIEW_TYPE_FOOTER_LOADING = 3;
//    static final int VIEW_TYPE_ERROR = -1;

    public static final int VIEW_TYPE_POST_CONTENT = 1;
    public static final int VIEW_TYPE_PINGLUN_DIANZAN_CONTAINER = 2;
    public static final int VIEW_TYPE_POST_PINGLUN = 3;
    public static final int VIEW_TYPE_POST_DIANZAN = 4;

    private ViewTypeFactory() {
    }


    public static RecyclerViewAdapter.ViewType createPostContent() {
        return new RecyclerViewAdapter.ViewType(VIEW_TYPE_POST_CONTENT, R.layout.item_post_content, PostViewHolder.class);
    }



    public static RecyclerViewAdapter.ViewType createPinglunDianzanContainer() {
        return new RecyclerViewAdapter.ViewType(VIEW_TYPE_PINGLUN_DIANZAN_CONTAINER, R.layout.item_pinglun_dianzan_container, PinglunDianzanContainerViewHolder.class);
    }

}
