package com.appcore.app;

import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @deprecated Use {@link AppCompatActivity} instead.
 */
@Deprecated
public abstract class Activity extends AppCompatActivity {

    public Activity() {
        super();
    }

    @ContentView
    public Activity(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }
}