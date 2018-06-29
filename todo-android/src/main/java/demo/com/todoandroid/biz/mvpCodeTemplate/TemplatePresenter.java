package demo.com.todoandroid.biz.mvpCodeTemplate;

/**
 * Author: benjamin
 * Time: 2018/6/11:上午10:32
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class TemplatePresenter implements TemplateContract.Presenter {
    private static final String TAG = "MineResetPsdPresenter";
    private final TemplateFragment fragment;

    public TemplatePresenter(TemplateFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void start() {

    }

    @Override
    public void cancel() {

    }
}
