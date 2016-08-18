package com.appcore.widget.adapters;

import android.view.View;

/**
 * Created by Viнt@rь on 12.05.2016
 */
public interface OnItemLongClickListener<T> {
    boolean onItemLongClick(View view, T item, int position);
}