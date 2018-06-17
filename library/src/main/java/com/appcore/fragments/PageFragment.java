package com.appcore.fragments;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Viнt@rь on 08.04.2016
 */
public interface PageFragment {

    CharSequence getTitle(@NonNull Context context);

    void onSelected(); // TODO in java 8 implement this method
}