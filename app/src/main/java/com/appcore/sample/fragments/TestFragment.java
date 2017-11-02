package com.appcore.sample.fragments;

import android.content.res.Resources;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.TextView;

import com.appcore.fragments.Fragment;
import com.appcore.sample.R;
import com.appcore.utils.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Viнt@rь on 20.04.2017
 */
public class TestFragment extends Fragment {

    private final long mStartTime = System.currentTimeMillis() - DateUtils.DAY_IN_MILLIS * 30;

    @BindView(R.id.test_text_view)
    TextView mTestTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("TEST", "TEST2 " + System.currentTimeMillis());
    }

    /*
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        Log.d("TEST", "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("TEST", "onViewCreated");
    }
*/

    @OnClick(R.id.test_button)
    public void onTestClick() {

/*        Log.d("TEST", String.valueOf(DateUtils.getRelativeTimeSpanString(mStartTime, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS,
               DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL)));

        Log.d("TEST", String.valueOf(formatDuration(DateUtils.SECOND_IN_MILLIS * 101)));

        Log.d("TEST", getResources().getQuantityString(R.plurals.activity_favorite, 1));
        Log.d("TEST", String.format(getResources().getQuantityString(R.plurals.activity_favorite, 10), "andre and 10"));*/
        //Log.d("TEST", getResources().getQuantityString(R.plurals.activity_favorite, 10));
/*

        Log.d("TEST", String.valueOf(DateFormat.getTimeFormat(getContext()).format(new Date(System.currentTimeMillis()))));
        //Log.d("TEST", String.valueOf(DateFormat.getTimeFormatString());
        Log.d("TEST", String.valueOf(DateFormat.format(DateFormatUtils.DATE_PATTERN, System.currentTimeMillis())));



        Log.d("TEST", String.valueOf(formatDuration(DateUtils.HOUR_IN_MILLIS * 101)));

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            TimeUnit.DAYS.toMillis(TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis()));
        }

        Log.d("TEST", "elapsed Time = " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            long date = System.currentTimeMillis() - System.currentTimeMillis() % 86400000;
        }

        Log.d("TEST", "elapsed Time 2 = " + (System.currentTimeMillis() - startTime));
*/

/*        DateTimeUtils;
        DateTimeFormatUtils;
        TimeFormatUtils;
        TimeFormat;*/

        //Log.d("TEST", String.valueOf(DateFormat.format("d MMMM, HH:mm", System.currentTimeMillis())));
        //Log.d("TEST", String.valueOf(DateFormat.format("d MMMM, HH:mm", System.currentTimeMillis())));
        /*
        long[] times = new long[] {
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000,
                1499864941 * 1000,
                1499864919 * 1000,
                1499864859 * 1000,
                1499856876 * 1000,
                1499773782 * 1000,
                1499328683 * 1000,
                1499870120 * 1000,
                1499809488 * 1000,
                1499683884 * 1000,
                1494885903 * 1000,
                1491833511 * 1000,
                1486674744 * 1000,
                1486674739 * 1000,
                1486674735 * 1000
        };

        Log.d("TEST", "---------------------------------------------------------------------");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times.length; i++) {
            formatTimeNew(times[i]);
        }

        Log.d("TEST", "First test = " + (System.currentTimeMillis() - startTime));
        Log.d("TEST", "---------------------------------------------------------------------");

        Log.d("TEST", "---------------------------------------------------------------------");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < times.length; i++) {
            formatTimeNew2(times[i]);
        }

        Log.d("TEST", "Second test = " + (System.currentTimeMillis() - startTime));
        Log.d("TEST", "---------------------------------------------------------------------");

        Log.d("TEST", "---------------------------------------------------------------------");
        startTime = System.currentTimeMillis();
        for (int j = 0; j < times.length; j++) {
            formatTimeNative(times[j]);
        }

        Log.d("TEST", "Third test = " + (System.currentTimeMillis() - startTime));
        Log.d("TEST", "---------------------------------------------------------------------");*/
    }

    private static final SimpleDateFormat WEEK_FORMAT = new SimpleDateFormat("d MMMM, HH:mm", Locale.getDefault());
    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("EEEE, HH:mm", Locale.getDefault());

    protected String formatTimeNew(long milliseconds) {
        long duration = Math.abs(System.currentTimeMillis() - milliseconds);

        long days = TimeUnit.MILLISECONDS.toDays(duration);
        if (days <= 0) {
            return formatTimeNative(milliseconds);
        } else {
            if (days > 7) {
                return WEEK_FORMAT.format(milliseconds);
            }
            return capitalize(DAY_FORMAT.format(milliseconds));
        }
    }

    protected String formatTimeNew2(long milliseconds) {
        long duration = Math.abs(System.currentTimeMillis() - milliseconds);

        //long days = TimeUnit.MILLISECONDS.toDays(duration);
        if (duration < DateUtils.DAY_IN_MILLIS) {
            return formatTimeNative(milliseconds);
        } else {
            if (duration > DateUtils.WEEK_IN_MILLIS) {
                return WEEK_FORMAT.format(milliseconds);
            }
            return capitalize(DAY_FORMAT.format(milliseconds));
        }
    }

    protected String formatTime(long seconds) {
        long pastSeconds = Math.abs(System.currentTimeMillis() / 1000 - seconds);

        long days = TimeUnit.SECONDS.toDays(pastSeconds);
        long hours = TimeUnit.SECONDS.toHours(pastSeconds);
        long minutes = TimeUnit.SECONDS.toMinutes(pastSeconds);

        if (days > 0) {
            if (days > 7) {
                return DateFormatUtils.format("d MMMM, HH:ss", seconds * 1000);
            }
            return capitalize(DateFormatUtils.format("EEEE, HH:ss", seconds * 1000));
        } else if (hours > 0) {
            return getString(R.string.activity_h_ago, hours);
        } else if (minutes > 0) {
            return getString(R.string.activity_m_ago, minutes);
        }

        return getString(R.string.now);
    }

    protected String formatTimeNative(long milliseconds) {
        int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_TIME;
        return String.valueOf(DateUtils.getRelativeTimeSpanString(milliseconds, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS, flags));
    }

    public static String capitalize(String string) {
        if (string != null && !string.isEmpty()) {
            char firstChar = string.charAt(0);
            if (!Character.isTitleCase(firstChar)) {
                string = Character.toTitleCase(firstChar) + string.substring(1);
            }
        }
        return string;
    }

    public CharSequence formatDuration(long millis) {
        final Resources res = getResources();
        if (millis >= DateUtils.WEEK_IN_MILLIS) {
            final int weeks = (int) (millis / DateUtils.WEEK_IN_MILLIS);
            return res.getQuantityString(R.plurals.duration_weeks, weeks, weeks);
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
