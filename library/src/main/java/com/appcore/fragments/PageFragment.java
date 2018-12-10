package com.appcore.fragments;

import android.content.Context;

import androidx.annotation.NonNull;

/**
 * Created by Viнt@rь on 08.04.2016
 */
public interface PageFragment {

    CharSequence getTitle(@NonNull Context context);

    default void onSelected() {

    }
}