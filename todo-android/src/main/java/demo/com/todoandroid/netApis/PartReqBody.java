package demo.com.todoandroid.netApis;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * auth zzc
 * date 2018/2/7
 * desc ${desc}
 */

public class PartReqBody extends RequestBody {
    private RequestBody body;
    private String key;
    private String value;

    public PartReqBody(String key, String value) {
        this.key = key;
        this.value = value;
        body = createText(value);
    }

    @Override
    public MediaType contentType() {
        return body.contentType();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        body.writeTo(sink);
    }

    private RequestBody createText(String content) {
        return RequestBody.create(MediaType.parse("text/plain"), content);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
