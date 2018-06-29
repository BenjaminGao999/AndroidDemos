package demo.com.todoandroid.aboutRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.com.todoandroid.R;
import demo.com.todoandroid.interfaces.RecyclerViewClickListener;
import demo.com.todoandroid.interfaces.RecyclerViewListLoadmore;
import demo.com.todoandroid.interfaces.RecyclerViewLoadmoreListener;
import demo.com.todoandroid.javabeans.person.Stranger;

/**
 * Author: benjamin
 * Time: 2018/6/20:下午6:35
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

class RecyclerViewAdapter extends RecyclerView.Adapter implements RecyclerViewListLoadmore<Stranger> {

    private final ArrayList<Stranger> datas;
    private RecyclerViewClickListener<Stranger> listener;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_LOADMORE = 2;
    private RecyclerViewLoadmoreListener<Stranger> loadmoreListener;
    private boolean flag_no_more_data;

    public RecyclerViewAdapter() {
        datas = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (viewType == TYPE_ITEM) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_list, parent, false);
            return new ViewHolder(inflate);
        } else {


            View loadmoreView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_loadmore, parent, false
            );

            return new ViewHolderLoadmore(loadmoreView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_ITEM) {
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.bindData(position);
        }

        if (getItemViewType(position) == TYPE_LOADMORE) {
            ViewHolderLoadmore loadmore = (ViewHolderLoadmore) holder;
            loadmore.bindData();
        }
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        if (getItemCount() - 1 == position) {
            return TYPE_LOADMORE;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder instanceof ViewHolderLoadmore) {
            if (loadmoreListener != null) {
                loadmoreListener.loadmore();
            }

        }
    }

    @Override
    public void addData(List<Stranger> data) {
        if (data != null) {
            if (data.size() > 0) {
                flag_no_more_data = false;
                datas.addAll(data);
                notifyDataSetChanged();
            } else {
                // 没有更多数据了
                flag_no_more_data = true;
                notifyItemChanged(getItemCount() - 1);

            }
        }
    }

    @Override
    public void resetData(List<Stranger> data) {
        if (data != null) {
            flag_no_more_data = false;
            datas.clear();
            addData(data);
        }
    }

    @Override
    public void setClickListener(RecyclerViewClickListener<Stranger> listener) {
        this.listener = listener;
    }

    @Override
    public void setLoadmoreListener(RecyclerViewLoadmoreListener<Stranger> loadmoreListener) {
        this.loadmoreListener = loadmoreListener;
    }


    class ViewHolderLoadmore extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_loading)
        LinearLayout llLoading;
        @BindView(R.id.ll_no_more_data)
        LinearLayout llNoMoreData;

        ViewHolderLoadmore(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData() {
            llNoMoreData.setVisibility(flag_no_more_data ? View.VISIBLE : View.GONE);
            llLoading.setVisibility(flag_no_more_data ? View.GONE : View.VISIBLE);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_content)
        TextView tvContent;
        private Stranger bean;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onClick(view, bean);
                }
            });
        }

        public void bindData(int position) {
            bean = datas.get(position);

        }
    }
}
