package com.cicinnus.corelib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * SP工具类
 *
 *  用法:SpUtils.getInstance(context,sp_name)
 *              .putString(key1,value1)
 *              .putString(key2,value2)
 *              .putBoolean(key3,true)
 *              ...
 *              .apply();
 * putXX 之后必须调用apply()方法才会正确
 * @author Cicinnus
 */

public class SpUtils {
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;
    private static SpUtils instance;


    @SuppressLint("CommitPrefEdits")
    public static SpUtils getInstance(Context context, String fileName) {
        if (instance == null) {
            instance = new SpUtils();
        }
        sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = sp.edit();

        return instance;
    }

    /**
     * 最后需要调用，否则无法保存
     */
    public void apply() {
        editor.commit();
    }

    public void commit(){
        editor.commit();
    }

    /**
     * 删除所有数据
     */
    public void deleteSPData() {
        editor.clear().apply();
    }


    public SpUtils putString(String key, String value) {
        editor.putString(key, value);
        return this;
    }

    public String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }


    public SpUtils putInt(String key, int value) {
        editor.putInt(key, value);
        return this;
    }

    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public SpUtils putLong(String key, Long value) {
        editor.putLong(key, value);
        return this;
    }

    public SpUtils putDouble(String key, Double value) {
        editor.putLong(key, Double.doubleToRawLongBits(value));
        return this;
    }

    public Double getDouble(String key, Double defValue) {
        return Double.longBitsToDouble(sp.getLong(key, Double.doubleToLongBits(defValue)));
    }


    public Long getLong(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    public SpUtils putBoolean(String key, boolean isAccess) {
        editor.putBoolean(key, isAccess);

        return this;
    }

    public Boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }
}
