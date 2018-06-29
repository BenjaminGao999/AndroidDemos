package demo.com.todoandroid.widgets;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.WindowManager;

import demo.com.todoandroid.R;


/**
 * Author: benjamin
 * Time: 2018/6/23:下午5:37
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public  abstract class DialogSuccessful extends Dialog {

    public DialogSuccessful(@NonNull Context context) {
        this(context, R.style.StyleDialogSuccessful);
    }

    public DialogSuccessful(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
            attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
            attributes.gravity = Gravity.CENTER;
            getWindow().setAttributes(attributes);
        }
        setContentView(getLayoutResId());
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutResId();


}
