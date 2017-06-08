package com.appcore.fragments;

import android.support.annotation.StringRes;

/**
 * Created by Viнt@rь on 08.04.2016
 */
public interface PageFragment {

    @StringRes
    int getTitle();

    void onSelected();
}