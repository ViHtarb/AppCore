package com.appcore.sample.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;

/**
 * Created by Viнt@rь on 09.07.2018
 */
public class SeekBar extends AppCompatSeekBar {

    private final int BACKGROUND_COLOR = Color.parseColor("#DFE0E2");
    private final int PROGRESS_COLOR = Color.parseColor("#7b7fc9");

    private int mStrokeWidth = 20;              // Width of outline
    private int mAnimationDuration = 400;       // Animation duration for progress change
    private int mMinProgress = 6;

    private final CircleProgressDrawable mDrawable;

    public SeekBar(Context context) {
        this(context, null);
    }

    public SeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mDrawable = new CircleProgressDrawable();
    }

    @Override
    public synchronized void setIndeterminate(boolean indeterminate) {
        //super.setIndeterminate(indeterminate);
    }

    @Override
    public void setIndeterminateDrawable(Drawable d) {
        //super.setIndeterminateDrawable(d);
    }

    @Override
    public void setIndeterminateDrawableTiled(Drawable d) {
        //super.setIndeterminateDrawableTiled(d);
    }

    @Override
    public void setProgressDrawable(Drawable d) {
        //super.setProgressDrawable(d);
    }

    @Override
    public void setProgressDrawableTiled(Drawable d) {
        //super.setProgressDrawableTiled(d);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDrawable.draw(canvas);
    }

    private class CircleProgressDrawable extends Drawable {

        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        @Override
        public void draw(@NonNull Canvas canvas) {
            drawBackground(canvas);
            drawProgress(canvas);
            drawSecondaryProgress(canvas);
        }

        @Override
        public void setAlpha(int alpha) {

        }

        @Override
        public void setColorFilter(@Nullable ColorFilter colorFilter) {

        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSPARENT; // TODO
        }

        private void drawBackground(Canvas canvas) {
            final float pad = (float) (mStrokeWidth / 2.0);
            final RectF outerOval = new RectF(pad, pad, getWidth() - pad, getHeight() - pad);

            mPaint.setColor(BACKGROUND_COLOR);
            mPaint.setStrokeWidth(mStrokeWidth);
            mPaint.setAntiAlias(true);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(outerOval, 0, 280, false, mPaint);
        }

        private void drawProgress(Canvas canvas) {

        }

        private void drawSecondaryProgress(Canvas canvas) {

        }
    }
}
