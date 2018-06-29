
package demo.com.todoandroid.javabeans.person;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonWrapper {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("stranger")
    @Expose
    private List<Stranger> stranger = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Stranger> getStranger() {
        return stranger;
    }

    public void setStranger(List<Stranger> stranger) {
        this.stranger = stranger;
    }

}
