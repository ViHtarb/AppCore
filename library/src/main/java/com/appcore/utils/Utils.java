package com.appcore.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.PermissionChecker;

import com.appcore.app.Application;
import com.google.android.gms.iid.InstanceID;

import java.util.Locale;

/**
 * Created by Viнt@rь on 03.05.2016
 */
public final class Utils {

    private Utils() {
        // not instantiate
    }

    @PermissionChecker.PermissionResult
    public static boolean checkPermission(Context context, String permission) {
        return PermissionChecker.checkSelfPermission(context, permission) == PermissionChecker.PERMISSION_GRANTED;
    }

    /**
     * @return dp converted from px
     */
    public static float dpFromPx(float px) {
        return px / Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * @return px converted from dp
     */
    public static float pxFromDp(float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * @return the device imei
     */
    public static String getImei() {
        return InstanceID.getInstance(Application.getContext()).getId();
    }

    /**
     * @return current device locale
     */
    public static String getLocale() {
        return Locale.getDefault().getLanguage();
    }
}
