package com.cicinnus.doubanplus.utils;

import android.widget.Toast;

import com.cicinnus.doubanplus.app.App;


/**
 * Created by Cicinnus on 2017/5/3.
 */

public class ToastUtil {

    private static Toast toast;


    public static void showToast(String errorMsg) {
        if (errorMsg == null) {
            return;
        }
        if (toast != null) {
            toast.setText(errorMsg);
        }else {
            toast = Toast.makeText(App.getInstance(),errorMsg,Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
