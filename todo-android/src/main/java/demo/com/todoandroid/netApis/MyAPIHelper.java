package demo.com.todoandroid.netApis;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Author: benjamin
 * Time: 2018/6/14:下午12:09
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class MyAPIHelper {
    private static final String TAG = "MyAPIHelper";
    private static final MyAPIHelper ourInstance = new MyAPIHelper();
    private final OkHttpClient sClient;

    public static MyAPIHelper getInstance() {
        return ourInstance;
    }

    private MyAPIHelper() {
        sClient = new OkHttpClient.Builder()
                .addInterceptor(new OpInterceptor())
//                .addInterceptor(new LogInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }


    /**
     *
     * @param requestBody
     * @param api
     * @param myCallback
     */
    public void request(RequestBody requestBody, String api, MyCallback myCallback) {

        Request request = new Request.Builder()
                .url(api)
                .post(requestBody)
                .build();


        Observable.create((ObservableOnSubscribe<String>) emitter -> {

            try {
                Response response = sClient.newCall(request).execute();
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                emitter.onNext(response.body().string());

            } catch (Exception e) {
                e.printStackTrace();
                emitter.onError(e);
            }

        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        myCallback.onResponse(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
