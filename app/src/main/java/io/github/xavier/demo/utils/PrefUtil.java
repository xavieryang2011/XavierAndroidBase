package io.github.xavier.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by xavier on 16/3/30.
 */
public class PrefUtil {

    private static final String PRE_NAME = "io.github.xavier.purezhihud_preferences";
    private static final String PRE_NIGHT = "night";

    private static SharedPreferences getSharedPreferences(Context context) {
        return context
                .getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);

    }

    public static void setNight(Context context) {
        getSharedPreferences(context.getApplicationContext()).edit().putBoolean(PRE_NIGHT, true).commit();
    }

    public static void setDay(Context context) {
        getSharedPreferences(context.getApplicationContext()).edit().putBoolean(PRE_NIGHT, false).commit();
    }

    public static void changeDayNight(Context context) {
        boolean change = !getSharedPreferences(context).getBoolean(PRE_NIGHT, false);
        getSharedPreferences(context.getApplicationContext()).edit().putBoolean(PRE_NIGHT, change).commit();
    }

    public static boolean isNight(Context context) {
        return getSharedPreferences(context.getApplicationContext()).getBoolean(PRE_NIGHT, false);
    }

    public static int getThemeRes(Context context) {
        if (!isNight(context)) {
            return Constant.RESOURCES_DAYTHEME;
        } else {
            return Constant.RESOURCES_NIGHTTHEME;
        }
    }
}
