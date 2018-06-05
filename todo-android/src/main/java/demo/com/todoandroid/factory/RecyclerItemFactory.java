package demo.com.todoandroid.factory;


import demo.com.todoandroid.base.RecyclerViewAdapter;

/**
 * @auth zzc
 * @date 2018/1/8
 * @desc ${item 工厂}
 * <p>
 * RecyclerItem 包含2部分
 * <p>
 * viewType
 * <p>
 * pojo
 */

public class RecyclerItemFactory {
    private RecyclerItemFactory() {

    }

    public static RecyclerViewAdapter.RecyclerItem createPostContentItem(Object obj) {
        return new RecyclerViewAdapter.RecyclerItem(ViewTypeFactory.VIEW_TYPE_POST_CONTENT, obj);
    }


    public static RecyclerViewAdapter.RecyclerItem createPinglunDianzanContainerItem(Object obj) {
        return new RecyclerViewAdapter.RecyclerItem(ViewTypeFactory.VIEW_TYPE_PINGLUN_DIANZAN_CONTAINER, obj);
    }

}
