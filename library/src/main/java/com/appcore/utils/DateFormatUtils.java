package com.appcore.utils;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Viнt@rь on 06.07.2016
 */
public final class DateFormatUtils {

    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();

    public static final String MINUTES_PATTERN = "mm:ss";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_PATTERN = "dd.MM.yyyy";

    private DateFormatUtils() {
        // not instantiate
        DATE_FORMAT.setTimeZone(TimeZone.getDefault());
    }

    public static String format(@NonNull final String pattern, final long millis) {
        return format(pattern, new Date(millis));
    }

    public static String format(@NonNull final String pattern, @NonNull final Calendar calendar) {
        return format(pattern, calendar.getTimeInMillis());
    }

    public static String format(@NonNull final String pattern, @NonNull final Date date) {
        DATE_FORMAT.applyPattern(pattern);
        return DATE_FORMAT.format(date);
    }
}