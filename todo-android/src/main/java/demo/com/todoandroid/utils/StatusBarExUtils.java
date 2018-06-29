package demo.com.todoandroid.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @auth zzc
 * @date 2018/1/8
 * @desc ${desc}
 */

public class StatusBarExUtils {
    private StatusBarExUtils() {
    }

    /**
     * 设置通知栏字体颜色
     *
     * @param activity
     * @param black    true ->深色，false ->白色
     */
    public static void setStatusBarColor(Activity activity, boolean black) {
        setMIUIStatusBarLightMode(activity, black);
        setFlymeStatusBarLightMode(activity, black);
        if (Build.VERSION.SDK_INT >= 23) {
            View view = activity.getWindow().getDecorView();
            int flag = view.getSystemUiVisibility();
            if (black) {
                flag |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                flag &= -View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            view.setSystemUiVisibility(flag);
        }
    }

    private static boolean setMIUIStatusBarLightMode(Activity activity, boolean lightmode) {
        int i = 0;
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int darkModeFlag = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            if (lightmode) {
                i = darkModeFlag;
            }
            objArr[0] = i;
            objArr[1] = darkModeFlag;
            extraFlagField.invoke(window, objArr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean setFlymeStatusBarLightMode(Activity activity, boolean lightmode) {
        try {
            LayoutParams lp = activity.getWindow().getAttributes();
            Field darkFlag = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field meizuFlags = LayoutParams.class.getDeclaredField("meizuFlags");
            darkFlag.setAccessible(true);
            meizuFlags.setAccessible(true);
            int bit = darkFlag.getInt(null);
            int value = meizuFlags.getInt(lp);
            if (lightmode) {
                value |= bit;
            } else {
                value &= ~bit;
            }
            meizuFlags.setInt(lp, value);
            activity.getWindow().setAttributes(lp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
