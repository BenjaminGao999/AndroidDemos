package demo.com.todoandroid.netApis;

import retrofit2.Response;

/**
 * Created : zzc
 * Time : 2017/5/18
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public class NetException extends RuntimeException {
    public static final int ERROR_CONNECT = 1;
    public static final int ERROR_200 = 20000;

    private int code;
    private String msg;
    private Response response;

    public NetException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private NetException(int code, String msg, Response response) {
        this.code = code;
        this.msg = msg;
        this.response = response;
    }

    /**
     * 非200异常
     *
     * @param code
     * @param msg
     * @param response 请求相关
     * @return
     */
    public static NetException createNot200(int code, String msg, Response response) {
        NetException ex = new NetException(code, msg, response);
        return ex;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "NetException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", response=" + response +
                '}';
    }
}
