package demo.com.todoandroid.aboutRecyclerView;


import android.text.TextUtils;
import android.widget.Toast;


import demo.com.todoandroid.appStorage.SharePrefsConstants;
import demo.com.todoandroid.appStorage.SharePrefsHelper;
import demo.com.todoandroid.javabeans.person.PersonWrapper;
import demo.com.todoandroid.javabeans.person.Stranger;
import demo.com.todoandroid.netApis.APIs;
import demo.com.todoandroid.netApis.GsonHelper;
import demo.com.todoandroid.netApis.MyAPIHelper;
import demo.com.todoandroid.netApis.MyCallback;
import okhttp3.FormBody;

/**
 * Author: benjamin
 * Time: 2018/6/20:下午5:36
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class RecyclerViewPresenter implements RecyclerViewContract.Presenter {

    private final RecyclerViewFragment fragment;
    private boolean isCanceled;

    public RecyclerViewPresenter(RecyclerViewFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void start() {

    }

    @Override
    public void cancel() {
        isCanceled = true;
    }


    @Override
    public void request(int size, int offset) {
        FormBody formBody = new FormBody.Builder()
                .add("key_one",
                        SharePrefsHelper.getInstance()
                                .getString(SharePrefsConstants.OPERATE_UID, ""))
                .add("key_two", "value_one")
                .add("key_three", "value_two")
                .add("key_x", "value_x")
                .build();

        MyAPIHelper.getInstance()
                .request(formBody, APIs.TASK_UNREPAIRED_LIST,
                        new MyCallback() {
                            @Override
                            public void onFailure(String e) {

                            }

                            @Override
                            public void onResponse(String response) {
                                if (!isCanceled && !TextUtils.isEmpty(response)) {

                                    PersonWrapper wrapper = GsonHelper.getInstance()
                                            .fromJson(response, PersonWrapper.class);

                                    if (wrapper != null && wrapper.getCode() != 0) {
                                        Toast.makeText(fragment.getContext(), "数据加载失败，" + wrapper.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    if (wrapper != null && wrapper.getCode() == 0 && wrapper.getStranger() != null) {
                                        java.util.List<Stranger> list = wrapper.getStranger();

                                        fragment.addData(list);

                                    }
                                }

                            }
                        });

    }
}
