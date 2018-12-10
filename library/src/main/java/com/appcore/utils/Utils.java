package com.appcore.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import com.appcore.app.Application;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * Created by Viнt@rь on 03.05.2016
 */
public final class Utils {

    private Utils() {
        // not instantiate
    }

    public static boolean checkPermission(@NonNull Context context, @NonNull String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static int getScreenWidth() {
        return getScreenSize().x;
    }

    public static int getScreenHeight() {
        return getScreenSize().y;
    }

    public static int getScreenRealWidth() {
        return getScreenRealSize().x;
    }

    public static int getScreenRealHeight() {
        return getScreenRealSize().y;
    }

    /**
     * @return dp converted from px
     */
    public static float dpFromPx(float px) {
        return px / getDisplayMetrics().density;
    }

    /**
     * @return px converted from dp
     */
    public static float pxFromDp(float dp) {
        return dp * getDisplayMetrics().density;
    }

    /**
     * @return the Instance Id
     */
    public static String getInstanceId() {
        return Application.getInstanceId().getId();
    }

    /**
     * @return current device locale
     */
    public static String getLocale() {
        return Locale.getDefault().getLanguage();
    }

    private static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    private static Point getScreenSize() {
        Display display = Application.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    private static Point getScreenRealSize() {
        Point size = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Display display = Application.getWindowManager().getDefaultDisplay();
            display.getRealSize(size);
        } else {
            DisplayMetrics dm = getDisplayMetrics();
            size.set(dm.widthPixels, dm.heightPixels);
        }
        return size;
    }
}