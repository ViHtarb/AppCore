package com.appcore.widget.adapters;

import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Viнt@rь on 31.03.2016
 */
public interface OnItemSelectedListener<T> {
    void onItemSelected(@Nullable View view, T item, int position);
}
