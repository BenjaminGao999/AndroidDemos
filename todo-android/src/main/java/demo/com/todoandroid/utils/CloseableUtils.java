package demo.com.todoandroid.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @auth benjamin
 * @date 2018/1/8
 * @desc ${desc}
 */

public class CloseableUtils {
    private CloseableUtils() {
    }

    public static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            try {
                if (closeable == null) continue;
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
