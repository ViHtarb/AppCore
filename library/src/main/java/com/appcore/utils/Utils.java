package com.appcore.utils;

import android.content.Context;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;

import com.appcore.app.Application;

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
        return ContextCompat.checkSelfPermission(context, permission) == PermissionChecker.PERMISSION_GRANTED;
    }

    /**
     * @return the device imei
     */
    public static String getImei() {
        try {
            return Settings.Secure.getString(Application.getInstance().getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception ignored) {
            return "";
        }
    }

    /**
     * @return current device locale
     */
    public static String getLocale() {
        return Locale.getDefault().getLanguage();
    }
}
