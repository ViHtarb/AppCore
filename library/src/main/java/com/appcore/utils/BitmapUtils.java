package com.appcore.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Bitmap util contains helpers
 * methods for make works with bitmaps easier
 */
public final class BitmapUtils {
    private static final int DEFAULT_MIN_WIDTH_QUALITY = 640;

    private BitmapUtils() {
        // not instantiate
    }

    /**
     * Scaling bitmap from file
     *
     * @param file file contains path to bitmap
     * @return scaled bitmap
     */
    public static Bitmap scale(@NonNull File file) {
        return scale(file, DEFAULT_MIN_WIDTH_QUALITY);
    }

    /**
     * Scaling bitmap from file with custom quality
     *
     * @param file contains path to bitmap
     * @param maxWidth custom quality
     * @return scaled bitmap
     */
    public static Bitmap scale(@NonNull File file, int maxWidth) {
        return scale(file.getPath(), maxWidth);
    }

    /**
     * Scaling bitmap from path
     *
     * @param path to bitmap
     * @return scaled bitmap
     */
    public static Bitmap scale(@NonNull String path) {
        return scale(path, DEFAULT_MIN_WIDTH_QUALITY);
    }

    /**
     * Scaling bitmap from path with custom quality
     *
     * @param path to bitmap
     * @param maxWidth custom quality
     * @return scaled bitmap
     */
    public static Bitmap scale(@NonNull String path, int maxWidth) {
        return scale(BitmapFactory.decodeFile(path), maxWidth);
    }

    /**
     * Scaling bitmap
     *
     * @param bitmap bitmap file for scaling
     * @return scaled bitmap
     */
    public static Bitmap scale(@NonNull Bitmap bitmap) {
        return scale(bitmap, DEFAULT_MIN_WIDTH_QUALITY);
    }

    /**
     * Scaling bitmap
     *
     * @param bitmap   bitmap file for scaling
     * @param maxWidth max output bitmap width
     * @return scaled bitmap
     */
    public static Bitmap scale(@NonNull Bitmap bitmap, int maxWidth) {
        if (maxWidth <= 0) {
            throw new IllegalArgumentException("maxWidth must be more than 0");
        }

        float scale = Math.min(((float) maxWidth / bitmap.getWidth()), ((float) maxWidth / bitmap.getHeight()));
        return Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * scale), (int)(bitmap.getHeight() * scale), true);
    }

    /**
     * Saving bitmap to file in {@link Bitmap.CompressFormat#JPEG}
     *
     * @param bitmap to save
     * @param file output file
     * @return saved file
     */
    public static File save(@NonNull Bitmap bitmap, @NonNull File file) {
        return save(bitmap, file, 100);
    }

    /**
     * Saving bitmap to file in {@link Bitmap.CompressFormat#JPEG} with custom quality
     *
     * @param bitmap  to save
     * @param file    output file
     * @param quality image quality
     * @return saved file
     */
    public static File save(@NonNull Bitmap bitmap, @NonNull File file, int quality) {
        try {
            FileOutputStream stream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream);
            stream.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}