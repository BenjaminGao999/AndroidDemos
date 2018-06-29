package demo.com.todoandroid.netApis;

/**
 * Created : zzc
 * Time : 2017/5/18
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public class DataResponse<T> {
    public static final int SUCCESS = 0;
    public static final int REQUEST_FREQUENT = 42006;//验证吗请求过于频繁

    public static final int LOGIN_OUT = 42008;
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
