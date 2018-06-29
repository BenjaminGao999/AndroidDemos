package demo.com.todoandroid.netApis;

import com.google.gson.Gson;

import java.io.IOException;

import demo.com.todoandroid.utils.LogUtils;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;

public class LogInterceptor implements Interceptor {
    private static final String TAG = LogInterceptor.class.toString();

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        okhttp3.Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        LogUtils.i(TAG, "\n");
        LogUtils.i(TAG, "----------Start----------------");
        LogUtils.i(TAG, "| " + request.toString());
        String method = request.method();
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i)).append("=").append(body.encodedValue(i)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                LogUtils.i(TAG, "| RequestParams:{" + sb.toString() + "}");
            }
        }
        LogUtils.i(TAG, "| Response:" + content);
        LogUtils.i(TAG, "----------End:" + duration + "ms----------");
        try {
            new Gson().fromJson(content, DataResponse.class);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("api:").append(request.url())
                    .append("\n")
                    .append("code:").append(response.code())
                    .append("\n")
                    .append("detail:").append(response.message())
                    .append("\n");
            if ("POST".equals(request.method())) {
                sb.append("params:");
                StringBuilder sbParam = new StringBuilder();
                if (request.body() instanceof FormBody) {
                    FormBody body = (FormBody) request.body();
                    for (int i = 0; i < body.size(); i++) {
                        sbParam.append(body.encodedName(i)).append("=").append(body.encodedValue(i)).append(",");
                    }
                    sbParam.delete(sbParam.length() - 1, sbParam.length());
                    sb.append(sbParam).append("\n");
                }
            }
            sb.append("server error:").append("\n")
                    .append(content);
            sb.append("\n");
            throw new NetException(NetException.ERROR_200, sb.toString());
        }
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
