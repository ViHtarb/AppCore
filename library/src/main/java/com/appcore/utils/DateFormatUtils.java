package com.appcore.utils;

import android.content.res.Resources;
import android.text.format.DateFormat;
import android.text.format.DateUtils;

import com.appcore.R;
import com.appcore.app.Application;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;

/**
 * Created by Viнt@rь on 06.07.2016
 */
public final class DateFormatUtils {

    public static final String MINUTES_PATTERN = "mm:ss";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_PATTERN = "dd.MM.yyyy";

    private DateFormatUtils() {
        // not instantiate
    }

    /**
     * @deprecated Use {@link android.text.format.DateFormat#format(CharSequence, long)} instead.
     */
    @Deprecated
    public static String format(@NonNull final CharSequence pattern, final long millis) {
        return String.valueOf(DateFormat.format(pattern, millis));
    }

    /**
     * @deprecated Use {@link android.text.format.DateFormat#format(CharSequence, Date)} instead.
     */
    @Deprecated
    public static String format(@NonNull final CharSequence pattern, @NonNull final Date date) {
        return String.valueOf(DateFormat.format(pattern, date));
    }

    /**
     * @deprecated Use {@link android.text.format.DateFormat#format(CharSequence, Calendar)} instead.
     */
    @Deprecated
    public static String format(@NonNull final CharSequence pattern, @NonNull final Calendar calendar) {
        return String.valueOf(DateFormat.format(pattern, calendar));
    }

    /**
     * Returns the given duration in a human-friendly format. For example,
     * "4 minutes" or "1 second". Returns only the largest meaningful unit of time,
     * from seconds up to weeks.
     */
    public static String formatDuration(long millis) {
        final Resources res = Application.getAppResources();
        if (millis >= DateUtils.WEEK_IN_MILLIS) {
            final int weeks = (int) (millis / DateUtils.WEEK_IN_MILLIS);
            return res.getQuantityString(R.plurals.duration_weeks, weeks, weeks);
        } else if (millis >= DateUtils.DAY_IN_MILLIS) {
            final int days = (int) (millis / DateUtils.DAY_IN_MILLIS);
            return res.getQuantityString(R.plurals.duration_days, days, days);
        } else if (millis >= DateUtils.HOUR_IN_MILLIS) {
            final int hours = (int) (millis / DateUtils.HOUR_IN_MILLIS);
            return res.getQuantityString(R.plurals.duration_hours, hours, hours);
        } else if (millis >= DateUtils.MINUTE_IN_MILLIS) {
            final int minutes = (int) (millis / DateUtils.MINUTE_IN_MILLIS);
            return res.getQuantityString(R.plurals.duration_minutes, minutes, minutes);
        } else {
            final int seconds = (int) (millis / DateUtils.SECOND_IN_MILLIS);
            return res.getQuantityString(R.plurals.duration_seconds, seconds, seconds);
        }
    }
}