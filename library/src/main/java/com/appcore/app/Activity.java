package com.appcore.app;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.appcore.R;
import com.appcore.R2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Base implementation of {@link AppCompatActivity} with using {@link ButterKnife}
 *
 * <p>
 * If you want to use {@link #openFragment(Fragment)} method, your activity layout
 * must contain {@link View} with {@link R.id#container} id.
 * </p>
 */
public abstract class Activity extends AppCompatActivity {

    @Nullable
    @Bind(R2.id.container)
    View mContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    @CallSuper
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
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
     */
    protected void openFragment(@NonNull Fragment fragment) {
        if (mContainer != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        } else {
            throw new RuntimeException("Error opening fragment. View with id R.id.container not found in activity layout");
        }
    }

    /**
     * Return the current activity layout id.
     */
    @LayoutRes
    protected abstract int getLayoutId();
}
