package com.appcore.widget.adapters;

import android.view.View;

/**
 * Created by Viнt@rь on 06.11.2015
 */
public interface OnItemClickListener<T> {
    void onItemClick(View view, T item, int position);
}
