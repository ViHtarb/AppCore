package com.appcore.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * Created by Viнt@rь on 05.10.2016
 */
public final class ViewUtils {

    private ViewUtils() {
        // not instantiate
    }

    public static Rect getLocationOnScreen(@NonNull View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Rect(location[0], location[1], location[0] + view.getMeasuredWidth(), location[1] + view.getMeasuredHeight());
    }

    public static Rect getLocationInWindow(@NonNull View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Rect(location[0], location[1], location[0] + view.getMeasuredWidth(), location[1] + view.getMeasuredHeight());
    }

    public static Rect getGlobalVisibleRect(@NonNull View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }

    public static boolean isInside(@NonNull View view, float x, float y) {
        Rect rect = getGlobalVisibleRect(view);
        return isInsideX(rect, x) && isInsideY(rect, y);
    }

    public static boolean isInsideX(@NonNull View view, float x) {
        Rect rect = getGlobalVisibleRect(view);
        return isInsideX(rect, x);
    }

    public static boolean isInsideY(@NonNull View view, float y) {
        Rect rect = getGlobalVisibleRect(view);
        return isInsideY(rect, y);
    }

    private static boolean isInsideX(Rect rect, float x) {
        return x >= rect.left && x <= rect.right;
    }

    private static boolean isInsideY(Rect rect, float y) {
        return y >= rect.top && y <= rect.bottom;
    }
}