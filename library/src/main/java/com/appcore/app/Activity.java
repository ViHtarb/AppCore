package com.appcore.app;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.appcore.R;

import androidx.annotation.CallSuper;
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
 *
 * <p>
 * If you want to use {@link #openFragment(Fragment)} method, your activity layout
 * must contain {@link View} with {@link R.id#container} id.
 * </p>
 */
public abstract class Activity extends AppCompatActivity {

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
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    /**
     * Return the current activity layout id.
     */
    @LayoutRes
    protected abstract int getLayoutId();
}