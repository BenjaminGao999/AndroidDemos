package demo.com.todoandroid.base;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import demo.com.todoandroid.utils.LogUtils;
import demo.com.todoandroid.R;

public abstract class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.ViewHolder> implements IDataHandler {
    private static final String TAG = RecyclerViewAdapter.class.toString();
    private AdapterListener mAdapterListener;
    private OnRecyclerItemLongClickListener mItemLongClickListener;
    private OnRecyclerItemClickListener mItemOnClickListener;
    private final List<RecyclerItem> mItems;
    private final ArrayMap<Integer, ViewType> mViewTypes;

    public static class ViewHolder<T> extends android.support.v7.widget.RecyclerView.ViewHolder implements OnClickListener {
        protected T data;
        protected RecyclerViewAdapter mAdapter;
        protected OnRecyclerItemClickListener<T> mOnRecyclerItemClickListener;
        protected OnRecyclerItemLongClickListener<T> mOnRecyclerItemLongClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        protected void setAdapter(RecyclerViewAdapter adapter) {
            this.mAdapter = adapter;
        }

        protected void onBindData(T data) {
            this.data = data;
        }

        protected void onUnbind() {
            this.data = null;
        }

        public void setOnClickListener(OnRecyclerItemClickListener<T> onClickListener) {
            this.mOnRecyclerItemClickListener = onClickListener;
        }

        public void setOnLongClickListener(OnRecyclerItemLongClickListener<T> onLongClickListener) {
            this.mOnRecyclerItemLongClickListener = onLongClickListener;
        }

        public void onAttachedToWindow() {
        }

        public void onDetachedFromWindow() {
        }

        protected Resources getResources() {
            return this.itemView.getResources();
        }

        public void onClick(View view) {
            if (this.mOnRecyclerItemClickListener != null) {
                this.mOnRecyclerItemClickListener.onClick(view, this);
            }
        }

        public T getData() {
            return this.data;
        }

        public Context getContext() {
            return this.itemView.getContext();
        }
    }

    public interface OnRecyclerItemClickListener<T> {
        void onClick(View view, ViewHolder<T> viewHolder);
    }

    public static class AdapterListener {
        public void onCreate(ViewHolder viewHolder) {
        }

        public void onPreBind(ViewHolder viewHolder, int position) {
        }

        public void onBind(ViewHolder viewHolder, int position) {
        }

        public void onUnbind(ViewHolder viewHolder) {
        }

        public void onAttachedToWindow(ViewHolder viewHolder) {
        }

        public void onDetachedFromWindow(ViewHolder viewHolder) {
        }
    }

    public interface OnRecyclerItemLongClickListener<T> {
        void onLongClick(View view, ViewHolder<T> viewHolder);
    }

    public static class RecyclerItem<T> {
        @NonNull
        private T mData;
        private final int mViewType;

        public RecyclerItem(int viewType, T data) {
            this.mViewType = viewType;
            this.mData = data;
        }

        public int getViewType() {
            return this.mViewType;
        }

        public T getData() {
            return this.mData;
        }

        public void setData(T data) {
            this.mData = data;
        }
    }

    public static class ViewType {
        private final int mLayoutResourceId;
        private final int mTypeId;
        private final Class<? extends ViewHolder> mViewHolderClass;

        public ViewType(int typeId, int layoutResourceId, Class<? extends ViewHolder> viewHolderClass) {
            this.mTypeId = typeId;
            this.mLayoutResourceId = layoutResourceId;
            this.mViewHolderClass = viewHolderClass;
        }

        public int getTypeId() {
            return this.mTypeId;
        }

        public int getLayoutResourceId() {
            return this.mLayoutResourceId;
        }

        public Class<? extends ViewHolder> getViewHolderClass() {
            return this.mViewHolderClass;
        }
    }

    protected abstract List<ViewType> onCreateViewTypes();

    public RecyclerViewAdapter() {
        this.mViewTypes = new ArrayMap<>();
        this.mItems = new ArrayList<>();
        for (ViewType viewType : onCreateViewTypes()) {
            this.mViewTypes.put(viewType.getTypeId(), viewType);
        }
    }

    public RecyclerViewAdapter(OnRecyclerItemClickListener itemOnClickListener) {
        this();
        this.mItemOnClickListener = itemOnClickListener;
    }

    public void setItemOnClickListener(OnRecyclerItemClickListener itemOnClickListener) {
        this.mItemOnClickListener = itemOnClickListener;
    }

    public void setItemLongClickListener(OnRecyclerItemLongClickListener itemLongClickListener) {
        this.mItemLongClickListener = itemLongClickListener;
    }

    @Override
    public void setRecyclerItem(int position, RecyclerItem recyclerItem) {
        this.mItems.set(position, recyclerItem);
        notifyItemChanged(position);
    }

    @Override
    public void addRecyclerItem(int position, RecyclerItem recyclerItems) {
        this.mItems.add(position, recyclerItems);
        notifyItemInserted(position);
    }

    @Override
    public void addRecyclerItem(RecyclerItem... recyclerItems) {
        int oldItemCount = getItemCount();
        Collections.addAll(this.mItems, recyclerItems);
        notifyItemRangeInserted(oldItemCount, recyclerItems.length);
    }

    @Override
    public void addRecyclerItemList(List<RecyclerItem> recyclerItemList) {
        int oldItemCount = getItemCount();
        this.mItems.addAll(recyclerItemList);
        notifyItemRangeInserted(oldItemCount, recyclerItemList.size());
    }

    @Override
    public void addRecyclerItemList(int position, List<RecyclerItem> recyclerItemList) {
        this.mItems.addAll(position, recyclerItemList);
        notifyItemRangeInserted(position, recyclerItemList.size());
    }

    @Override
    public int indexOf(Object data) {
        for (RecyclerItem item : this.mItems) {
            if (item.getData().equals(data)) {
                return indexOf(item);
            }
        }
        return -1;
    }

    @Override
    public int indexOf(RecyclerItem recyclerItem) {
        return this.mItems.indexOf(recyclerItem);
    }

    @Override
    @Nullable
    public RecyclerItem getRecyclerItem(int position) {
        return this.mItems.get(position);
    }

    @Override
    @Nullable
    public List<RecyclerItem> getRecyclerItems() {
        return this.mItems;
    }

    @Override
    public int recyclerItemSize() {
        return getItemCount();
    }

    @Override
    public void changeRecyclerItem(RecyclerItem recyclerItem, int position) {
        this.mItems.set(position, recyclerItem);
        notifyItemChanged(position);
    }

    @Override
    public void removeData(Object data) {
        for (RecyclerItem item : this.mItems) {
            if (item.getData().equals(data)) {
                removeRecyclerItem(item);
                return;
            }
        }
    }

    @Override
    public void removeRecyclerItem(int position) {
        if (position == -1) return;
        this.mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void removeRecyclerItem(RecyclerItem recyclerItem) {
        removeRecyclerItem(this.mItems.indexOf(recyclerItem));
    }

    @Override
    public void removeRecyclerItem(int position, int count) {
        this.mItems.subList(position, position + count).clear();
        notifyItemRangeRemoved(position, count);
    }

    @Override
    public void removeListItemsFrom(int position) {
        if (position <= getItemCount()) {
            this.mItems.subList(position, getItemCount()).clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public void clearAllRecyclerItem() {
        this.mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public void sortData(Comparator<RecyclerItem> comparator) {
        if (this.mItems.isEmpty()) return;
        Collections.sort(mItems, comparator);
        notifyDataSetChanged();
    }

    public boolean containViewType(int typeId) {
        return this.mViewTypes != null && this.mViewTypes.containsKey(typeId);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parentView, int type) {
        ViewType viewType = this.mViewTypes.get(type);
        if (viewType != null) {
            Class<? extends ViewHolder> viewHolderClass = viewType.getViewHolderClass();
            View view = LayoutInflater.from(parentView.getContext()).inflate(viewType.getLayoutResourceId(), parentView, false);
            try {
                ViewHolder viewHolder = viewHolderClass.getDeclaredConstructor(new Class[]{View.class}).newInstance(new Object[]{view});
                if (this.mAdapterListener != null) {
                    this.mAdapterListener.onCreate(viewHolder);
                }
                if (this.mItemOnClickListener != null) {
                    viewHolder.setOnClickListener(this.mItemOnClickListener);
                }
                if (this.mItemLongClickListener != null) {
                    viewHolder.setOnLongClickListener(this.mItemLongClickListener);
                }
                viewHolder.setAdapter(this);
                return viewHolder;
            } catch (Exception e) {
                throw new IllegalArgumentException(viewHolderClass.getSimpleName() + " create error");
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry value : this.mViewTypes.entrySet()) {
                stringBuilder.append(((ViewType) value.getValue()).getViewHolderClass().getSimpleName());
            }
            LogUtils.i(TAG, " missed some ViewHolder, owned ViewHolders: " + stringBuilder.toString());
            View view = LayoutInflater.from(parentView.getContext()).inflate(R.layout.item_common_default, parentView, false);
            return new DefaultViewHolder(view);
        }
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onPreBind(holder, position);
        }
        holder.onBindData(mItems.get(position).getData());
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onBind(holder, position);
        }
    }

    public void onViewRecycled(ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        viewHolder.onUnbind();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onUnbind(viewHolder);
        }
    }

    public int getItemViewType(int position) {
        return mItems.get(position).getViewType();
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public void onViewAttachedToWindow(ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        viewHolder.onAttachedToWindow();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onAttachedToWindow(viewHolder);
        }
    }

    public void onViewDetachedFromWindow(ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        viewHolder.onDetachedFromWindow();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onDetachedFromWindow(viewHolder);
        }
    }

    public void setAdapterListener(AdapterListener adapterListener) {
        this.mAdapterListener = adapterListener;
    }

    public int getPositionByData(Object data) {
        for (RecyclerItem item : this.mItems) {
            if (item.getData().equals(data)) {
                return this.mItems.indexOf(item);
            }
        }
        return -1;
    }
}