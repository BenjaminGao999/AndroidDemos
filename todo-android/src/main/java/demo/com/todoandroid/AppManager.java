package demo.com.todoandroid;

import java.util.ArrayList;

/**
 * Author: benjamin
 * Time: 2018/6/22:下午2:40
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class AppManager {

    private static ArrayList<BaseActivity> activityStack = new ArrayList<>();


    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(BaseActivity activity) {
        activityStack.add(activity);
    }


    /**
     * 结束指定的Activity
     */
    public static void finishActivity(BaseActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }


    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (BaseActivity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }


    public static void removeActivity(BaseActivity baseActivity) {
        activityStack.remove(baseActivity);
    }
}
