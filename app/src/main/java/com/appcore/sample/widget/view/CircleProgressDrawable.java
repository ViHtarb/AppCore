package com.appcore.sample.widget.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.appcore.sample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viнt@rь on 09.07.2018
 */
public class CircleProgressDrawable/* extends LayerDrawable*/ {
/*
    private static final int BACKGROUND_COLOR = Color.parseColor("#DFE0E2");
    private static final int PROGRESS_COLOR = Color.parseColor("#7b7fc9");

    *//**
     * Creates a new layer drawable with the list of specified layers.
     *
     * @param layers a list of drawables to use as layers in this new drawable,
     *               must be non-null
     *//*
    private CircleProgressDrawable(@NonNull Drawable[] layers) {
        super(layers);
    }

    public static CircleProgressDrawable create() {
        Drawable backgroundDrawable = new CircleProgressDrawableInternal(BACKGROUND_COLOR);
        //Drawable secondaryProgressDrawable = new CircleProgressDrawableInternal();
        Drawable progressDrawable = new CircleProgressDrawableInternal(PROGRESS_COLOR);

        List<Drawable> drawables = new ArrayList<>();
        drawables.add(backgroundDrawable);
        //drawables.add(secondaryProgressDrawable);
        drawables.add(progressDrawable);

        LayerDrawable layerDrawable = new CircleProgressDrawable((Drawable[]) drawables.toArray());
        layerDrawable.setId(0, android.R.id.background);
        //layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);

        return new CircleProgressDrawable((Drawable[]) drawables.toArray());
    }

    private static class CircleProgressDrawableInternal extends Drawable {

        private int mStrokeWidth = 20;              // Width of outline

        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        private int mColor;

        public CircleProgressDrawableInternal(@ColorInt int color) {
            mColor = color;
        }

        @Override
        public void draw(@NonNull Canvas canvas) {
            final float pad = (float) (mStrokeWidth / 2.0);
            final RectF outerOval = new RectF(pad, pad, getWidth() - pad, getHeight() - pad);

            mPaint.setColor(BACKGROUND_COLOR);
            mPaint.setStrokeWidth(mStrokeWidth);
            mPaint.setAntiAlias(true);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(outerOval, 0, 280, false, mPaint);
        }

        @Override
        public void setAlpha(int alpha) {

        }

        @Override
        public void setColorFilter(@Nullable ColorFilter colorFilter) {

        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSPARENT;
        }
    }*/
}
