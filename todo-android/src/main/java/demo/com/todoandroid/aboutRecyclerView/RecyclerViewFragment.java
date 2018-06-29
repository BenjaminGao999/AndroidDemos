package demo.com.todoandroid.aboutRecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.com.todoandroid.BaseFragment;
import demo.com.todoandroid.R;
import demo.com.todoandroid.javabeans.person.Stranger;
import demo.com.todoandroid.widgets.ItemDecorationCommonList;
import demo.com.todoandroid.widgets.MyLinearLayoutManager;
import demo.com.todoandroid.widgets.RecyclerViewStatusEnum;

/**
 * Author: benjamin
 * Time: 2018/6/20:下午5:35
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class RecyclerViewFragment extends BaseFragment<RecyclerViewPresenter> implements RecyclerViewContract.View {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    private static final int size = 10;
    private ArrayList<Stranger> datas;
    private RecyclerViewAdapter adapter;
    RecyclerViewStatusEnum statusEnum = RecyclerViewStatusEnum.none;

    @Override
    protected View goCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view_list, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        datas = new ArrayList<>();

        recyclerView.setLayoutManager(new MyLinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new ItemDecorationCommonList());
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

//        mPresenter.request(size, datas.size());

        swipeRefresh.setOnRefreshListener(() -> {
            if (statusEnum == RecyclerViewStatusEnum.none) {
                mPresenter.request(size, 0);
                statusEnum = RecyclerViewStatusEnum.refreshing;
            } else {
                swipeRefresh.setRefreshing(false);
            }
        });

        adapter.setClickListener((view, data) -> {
            Toast.makeText(getContext(), "item clicked", Toast.LENGTH_SHORT).show();


        });

        adapter.setLoadmoreListener(() -> {
                    if (statusEnum == RecyclerViewStatusEnum.none) {
                        mPresenter.request(size, datas.size());
                        statusEnum = RecyclerViewStatusEnum.loadmore;
                    }
                }
        );
    }


    @Override
    public void addData(java.util.List<Stranger> data) {
        if (data != null) {
            if (swipeRefresh.isRefreshing()) {
                adapter.resetData(data);
                swipeRefresh.setRefreshing(false);
                datas.clear();
                datas.addAll(data);
            } else {
                adapter.addData(data);
                datas.addAll(data);
            }
        }
        statusEnum = RecyclerViewStatusEnum.none;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {

            mPresenter.cancel();
        }
        super.onDestroyView();
        unbinder.unbind();
    }


}
