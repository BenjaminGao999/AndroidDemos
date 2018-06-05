package demo.com.todoandroid.biz.recyclerAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.HashSet;

import demo.com.todoandroid.R;
import demo.com.todoandroid.biz.viewHolder.ItemHolder;

/**
 * Created by panchenhuan on 17/8/25.
 */

public class RvAdapter extends RecyclerView.Adapter<ItemHolder> {
    private Context mContext;
    private static final String TAG = "RvAdapter";
    private final HashSet<Integer> mHashSet;

    public RvAdapter(Context context) {
        mContext = context;
        mHashSet = new HashSet<>();

    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemHolder itemHolder = new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv, parent, false));
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, int position) {
        String text = " === " + position + " === ";
        holder.mTextView.setText(text);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "holder.getAdapterPosition():" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

//        mHashSet.add(holder.hashCode());
//        if (position > getItemCount() - 2) {
//            Log.i(TAG, "onBindViewHolder: how many viewHolder instantial been created - "+mHashSet.size());
//        }
    }

    @Override
    public int getItemCount() {
        return 50;
    }
}
