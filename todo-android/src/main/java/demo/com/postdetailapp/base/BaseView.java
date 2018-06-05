package demo.com.postdetailapp.base;

/**
 * Author: benjamin
 * Time: 2018/5/31:上午11:39
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public interface BaseView<P extends BasePresenter> {

    void setPresenter(P presenter);

    P getPresenter();
}
