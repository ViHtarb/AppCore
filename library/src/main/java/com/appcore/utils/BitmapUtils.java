package com.appcore.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Viнt@rь on 18.01.2016
 */
public final class BitmapUtils {
    private static final int DEFAULT_MIN_WIDTH_QUALITY = 640;
    private static final int[] sSamples = {5, 3, 2, 1};

    private BitmapUtils() {
        // not instantiate
    }

    public static Bitmap resize(@NonNull File file) {
        return resize(file.getPath());
    }

    public static Bitmap resize(@NonNull File file, int maxWidth) {
        return resize(file.getPath(), maxWidth);
    }

    public static Bitmap resize(@NonNull String path) {
        return resize(path, DEFAULT_MIN_WIDTH_QUALITY);
    }

    /**
     * Sampling the bitmap by a file path
     *
     * @param path image file path
     * @return sampled bitmap
     */
    public static Bitmap resize(@NonNull String path, int maxWidth) {
        if (maxWidth <= 0) {
            throw new IllegalArgumentException("maxWidth must be more than 0");
        }

        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        for (int sample : sSamples) {
            options.inSampleSize = sample;

            bitmap = BitmapFactory.decodeFile(path, options);
            if (bitmap != null && bitmap.getWidth() >= maxWidth) {
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap resize(@NonNull Bitmap bitmap) {
        return resize(bitmap, DEFAULT_MIN_WIDTH_QUALITY);
    }

    /**
     * Resizing bitmap by a scale matrix
     *
     * @param bitmap   bitmap file for scaling
     * @param maxWidth max output bitmap width
     * @return scaled bitmap
     */
    public static Bitmap resize(@NonNull Bitmap bitmap, int maxWidth) {
        if (maxWidth <= 0) {
            throw new IllegalArgumentException("maxWidth must be more than 0");
        }

        float scale = Math.min(((float) maxWidth / bitmap.getWidth()), ((float) maxWidth / bitmap.getHeight()));
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /**
     * Saving bitmap to file with full quality
     */
    public static File save(@NonNull Bitmap bitmap, @NonNull File file) {
        return save(bitmap, file, 100);
    }

    /**
     * Saving bitmap to file in {@link Bitmap.CompressFormat#JPEG} compress format
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