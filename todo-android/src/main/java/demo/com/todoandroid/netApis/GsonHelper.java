package demo.com.todoandroid.netApis;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import demo.com.todoandroid.App;

/**
 * Author: benjamin
 * Time: 2018/6/14:下午2:47
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class GsonHelper {
    private static final GsonHelper ourInstance = new GsonHelper();
    private final Gson sGson;

    public static GsonHelper getInstance() {
        return ourInstance;
    }

    private GsonHelper() {
        sGson = new Gson();
    }

    public Gson getsGson() {
        Gson localGson = sGson;
        if (localGson == null) {
            localGson = new Gson();
        }
        return localGson;
    }


    public <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return getsGson().fromJson(json, classOfT);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            Toast.makeText(App.getContext(), "json数据解析失败", Toast.LENGTH_SHORT).show();
        }

        return null;
    }


    public String toJson(Object src) {
        try {
            return getsGson().toJson(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
