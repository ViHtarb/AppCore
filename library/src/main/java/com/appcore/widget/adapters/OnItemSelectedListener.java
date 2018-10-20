package com.appcore.widget.adapters;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.SelectionTracker.SelectionObserver;

/**
 * Created by Viнt@rь on 31.03.2016
 *
 * @deprecated Use {@link SelectionTracker} and {@link SelectionObserver} instead.
 */
@Deprecated
public interface OnItemSelectedListener<T> {

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    void onItemSelected(@Nullable View view, T item, int position);
}