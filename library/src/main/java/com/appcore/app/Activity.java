package com.appcore.app;

import android.os.Bundle;
import android.view.View;

import com.appcore.R;

import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;

/**
 * Base implementation of {@link AppCompatActivity} with using {@link ButterKnife}
 */
public abstract class Activity extends AppCompatActivity {

    public Activity() {
        super();
    }

    @ContentView
    public Activity(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != View.NO_ID) {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);
    }

    /**
     * Wrapper of {@link FragmentTransaction#replace(int, Fragment)}
     * method for simply opening new fragment.
     *
     * <p>
     * See {@link FragmentTransaction#replace(int, Fragment)}
     * for more details.
     * </p>
     *
     * @param fragment The new fragment to place in the container.
     * @deprecated Use <a href="https://developer.android.com/topic/libraries/architecture/navigation/">Navigation Architecture Component</a>
     *             or {@link FragmentTransaction#replace(int, Fragment)} instead.
     */
    @Deprecated
    protected void openFragment(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    /**
     * Return the current activity layout id.
     *
     * @deprecated Use {@link #Activity(int)} instead.
     */
    @Deprecated
    @LayoutRes
    protected int getLayoutId() {
        return View.NO_ID;
    }
}