package demo.com.todoandroid.netApis;


/**
 * Author: benjamin
 * Time: 2018/6/14:下午2:24
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public interface MyCallback {

    void onFailure(String e);


    void onResponse(String response);

}
