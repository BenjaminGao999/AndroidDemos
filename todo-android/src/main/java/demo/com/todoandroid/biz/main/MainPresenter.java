package demo.com.todoandroid.biz.main;

/**
 * Author: benjamin
 * Time: 2018/6/11:上午10:32
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class MainPresenter implements MainContract.Presenter {
    private static final String TAG = "MineResetPsdPresenter";
    private final MainFragment fragment;

    public MainPresenter(MainFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void start() {

    }

    @Override
    public void cancel() {

    }
}
