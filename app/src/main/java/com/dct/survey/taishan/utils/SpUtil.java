package com.dct.survey.taishan.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 创建： 付威
 * 时间： on 2017/3/7 20:54
 * 描述： 与SharedPreferences相关的工具类
 */

public class SpUtil {
    private static final String SHARE_PREFS_NAME = "sps";

    /**
     *  存入boolean类型的数据
     * @param ctx
     * @param key
     * @param value
     */
    public static void putBoolean(Context ctx, String key, boolean value) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        pref.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取boolean类型的数据
     * @param ctx
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Context ctx, String key,
                                     boolean defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        return pref.getBoolean(key, defaultValue);
    }

    /**
     * 存入String类型的数据
     * @param ctx
     * @param key
     * @param value
     */
    public static void putString(Context ctx, String key, String value) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        pref.edit().putString(key, value).commit();
    }

    /**
     * 获取boolean类型的数据
     * @param ctx
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Context ctx, String key, String defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        return pref.getString(key, defaultValue);
    }

    /**
     * 存入int类型的数据
     * @param ctx
     * @param key
     * @param value
     */
    public static void putInt(Context ctx, String key, int value) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        pref.edit().putInt(key, value).commit();
    }

    /**
     * 获取boolean类型的数据
     * @param ctx
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Context ctx, String key, int defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        return pref.getInt(key, defaultValue);
    }

    /**
     * 存入long类型的数据
     * @param ctx
     * @param key
     * @param value
     */
    public static void putLong(Context ctx, String key, long value) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        pref.edit().putLong(key, value).commit();
    }

    /**
     * 获取long类型的数据
     * @param ctx
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getLong(Context ctx, String key, long defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        return pref.getLong(key, defaultValue);
    }
}
