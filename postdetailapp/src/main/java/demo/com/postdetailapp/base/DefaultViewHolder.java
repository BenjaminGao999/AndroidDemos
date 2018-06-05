package demo.com.postdetailapp.base;

import android.view.View;

/**
 * auth zzc
 * date 2018/4/3
 * desc ${desc}
 */

public class DefaultViewHolder extends RecyclerViewAdapter.ViewHolder<DefaultViewHolder.DefaultMsg> {
    public DefaultViewHolder(View itemView) {
        super(itemView);
    }

    public static class DefaultMsg {
        public String msg;

        public DefaultMsg(String msg) {
            this.msg = msg;
        }
    }
}
