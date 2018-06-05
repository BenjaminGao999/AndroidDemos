package demo.com.todoandroid.utils;

import java.lang.reflect.ParameterizedType;


/**
 * desc:
 * 获取直接父类的泛型，并根据泛型获取实例
 */

public class InjectUtils {
    private InjectUtils() {
    }

    public static <P> P inject(Object obj, int index) {
        P presenter = null;
        ParameterizedType pt = (ParameterizedType) obj.getClass().getGenericSuperclass();
        Class c = (Class) pt.getActualTypeArguments()[index];
        try {
            presenter = (P) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            return presenter;
        }
    }
}
