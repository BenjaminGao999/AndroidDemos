package demo.com.todoandroid.aboutRecyclerView;


import java.util.List;

import demo.com.todoandroid.BasePresenter;
import demo.com.todoandroid.javabeans.person.Stranger;

/**
 * Author: benjamin
 * Time: 2018/6/20:下午5:33
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class RecyclerViewContract {
    interface View {

        void addData(List<Stranger> data);
    }

    interface Presenter extends BasePresenter {

        void request(int size, int offset);

    }


}
