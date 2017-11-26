package com.cicinnus.doubanplus.utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * @author Cicinnus
 *         on 2017/11/23.
 */

public class ActivityUtils {


    /**
     * 启动Activity
     * @param activity 当前activity
     * @param targetAct 目标activity
     */
    public static void jumpToActivity(Activity activity, Class<? extends Activity> targetAct) {
        Intent intent = new Intent(activity, targetAct);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity).toBundle();
            activity.startActivity(intent, bundle);

    }

    public static void JumpToActivity(Activity activity, Class<? extends Activity> targetAct,Bundle bundle){
        Intent intent = new Intent(activity, targetAct);
        activity.startActivity(intent, bundle);

    }

}
