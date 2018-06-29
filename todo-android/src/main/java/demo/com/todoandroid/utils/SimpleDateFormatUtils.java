package demo.com.todoandroid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: benjamin
 * Time: 2018/6/21:下午4:33
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class SimpleDateFormatUtils {
    private static final SimpleDateFormatUtils ourInstance = new SimpleDateFormatUtils();

    public static final String pattern_one = "yyyy-MM-dd HH:mm:ss";

    public static SimpleDateFormatUtils getInstance() {
        return ourInstance;
    }

    private SimpleDateFormatUtils() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
    }

    public String getPatternOneFormattedTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern_one);
        String format = simpleDateFormat.format(new Date());
        return format;
    }
}
