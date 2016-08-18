package com.appcore.app;

import android.app.DownloadManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationManagerCompat;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Implementation of {@link android.app.Application} with static wrappers
 * for ease of getting managers and other general objects.
 *
 * <p>
 * For example to get the {@link LayoutInflater} object simply use the
 * {@link #getInflater()} method.
 * </p>
 *
 * <p>
 * if you want to use this application class implementation, you must
 * specify it`s name in your AndroidManifest.xml's &lt;application&gt;
 * tag, which will cause that class to be instantiated for you when the
 * process for your application/package is created.
 * </p>
 */
public class Application extends android.app.Application {

    private static Application sInstance;
    public static Application getInstance() {
        return sInstance;
    }

    public Application() {
        sInstance = this;
    }

    /**
     * Static wrappers
     */
    public static Context getContext() {
        return sInstance.getBaseContext();
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    public static Resources getAppResources() {
        return sInstance.getResources();
    }

    public static LayoutInflater getInflater() {
        return LayoutInflater.from(sInstance);
    }

    public static SharedPreferences getDefaultPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(sInstance);
    }

    public static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) sInstance.getSystemService(TELEPHONY_SERVICE);
    }

    public static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) sInstance.getSystemService(CONNECTIVITY_SERVICE);
    }

    public static InputMethodManager getInputMethodManager() {
        return (InputMethodManager) sInstance.getSystemService(INPUT_METHOD_SERVICE);
    }

    public static DownloadManager getDownloadManager() {
        return (DownloadManager) sInstance.getSystemService(DOWNLOAD_SERVICE);
    }

    public static LocationManager getLocationManager() {
        return (LocationManager) sInstance.getSystemService(LOCATION_SERVICE);
    }

    public static WindowManager getWindowManager() {
        return (WindowManager) sInstance.getSystemService(WINDOW_SERVICE);
    }

    public static ClipboardManager getClipboardManager() {
        return (ClipboardManager) sInstance.getSystemService(CLIPBOARD_SERVICE);
    }

    public static NotificationManagerCompat getNotificationManager() {
        return NotificationManagerCompat.from(sInstance);
    }

    public static Vibrator getVibratorManager() {
        return (Vibrator) sInstance.getSystemService(VIBRATOR_SERVICE);
    }
}
