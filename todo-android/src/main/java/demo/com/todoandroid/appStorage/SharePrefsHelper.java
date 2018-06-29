package demo.com.todoandroid.appStorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import demo.com.todoandroid.App;

/**
 * Author: benjamin
 * Time: 2018/6/15:下午5:49
 * email: benjamin.gaozq@gmail.com
 * desc: key- value sharePreferences保存
 */

public class SharePrefsHelper {
    private static final SharePrefsHelper ourInstance = new SharePrefsHelper();
    private final SharedPreferences mSharePrefs;

    public static SharePrefsHelper getInstance() {
        return ourInstance;
    }

    private SharePrefsHelper() {
        mSharePrefs = App.getContext().getSharedPreferences(SharePrefsConstants.GROUP_NAME, Context.MODE_PRIVATE);
    }

    public boolean putString(String key, String value) {
        if (TextUtils.isEmpty(value)) {
            value = "";
        }
        return mSharePrefs.edit().putString(key, value).commit();
    }

    public String getString(String key, String defaultValue) {
        return mSharePrefs.getString(key, defaultValue);

    }


}

