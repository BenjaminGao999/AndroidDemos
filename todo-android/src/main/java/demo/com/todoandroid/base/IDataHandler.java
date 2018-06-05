package demo.com.todoandroid.base;

import android.support.annotation.Nullable;

import java.util.Comparator;
import java.util.List;

/**
 * @auth zzc
 * @date 2018/1/8
 * @desc ${desc}
 */

public interface IDataHandler {
    void setRecyclerItem(int position, RecyclerViewAdapter.RecyclerItem recyclerItem);

    void addRecyclerItem(int position, RecyclerViewAdapter.RecyclerItem recyclerItems);

    void addRecyclerItem(RecyclerViewAdapter.RecyclerItem... recyclerItems);

    void addRecyclerItemList(List<RecyclerViewAdapter.RecyclerItem> recyclerItemList);

    void addRecyclerItemList(int position, List<RecyclerViewAdapter.RecyclerItem> recyclerItemList);

    int indexOf(Object data);

    int indexOf(RecyclerViewAdapter.RecyclerItem recyclerItem);

    @Nullable
    RecyclerViewAdapter.RecyclerItem getRecyclerItem(int position);

    @Nullable
    List<RecyclerViewAdapter.RecyclerItem> getRecyclerItems();

    int recyclerItemSize();

    void changeRecyclerItem(RecyclerViewAdapter.RecyclerItem recyclerItem, int position);

    void removeData(Object data);

    void removeRecyclerItem(int position);

    void removeRecyclerItem(RecyclerViewAdapter.RecyclerItem recyclerItem);

    void removeRecyclerItem(int position, int count);

    void removeListItemsFrom(int position);

    void clearAllRecyclerItem();

    void sortData(Comparator<RecyclerViewAdapter.RecyclerItem> comparator);
}
