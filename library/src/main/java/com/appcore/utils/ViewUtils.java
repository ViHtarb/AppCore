package com.appcore.utils;

import android.graphics.Rect;
import android.view.View;

/**
 * Created by Viнt@rь on 05.10.2016
 */
public final class ViewUtils {

    private ViewUtils() {
        // not instantiate
    }

    public static boolean isInside(View view, float x, float y) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return isInsideX(rect, x) && isInsideY(rect, y);
    }

    public static boolean isInsideX(View view, float x) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return isInsideX(rect, x);
    }

    public static boolean isInsideY(View view, float y) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return isInsideY(rect, y);
    }

    private static boolean isInsideX(Rect rect, float x) {
        return rect.left <= x && rect.right >= x;
    }

    private static boolean isInsideY(Rect rect, float y) {
        return rect.top <= y && rect.bottom >= y;
    }
}
