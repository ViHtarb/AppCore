package com.appcore.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcore.R;
import com.appcore.R2;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Base implementation of {@link android.support.v4.app.Fragment} with using {@link ButterKnife}
 *
 * <p>
 * For using this fragment implementation your activity must be extend {@link AppCompatActivity}
 * </p>
 *
 * <p>
 * If in current fragment layout contains {@link R.id#toolbar} id then {@link Toolbar} object
 * set to activity automatically.
 * </p>
 *
 * <p>Fragments lifecycle:</p>
 * <ul>
 *  <li> Fragment is added
 *  <li> {@link #onAttach(Context)}
 *  <li> {@link #onCreate(Bundle)}
 *  <li> {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
 *  <li> {@link #onViewCreated(View, Bundle)}
 *  <li> {@link #onActivityCreated(Bundle)}
 *  <li> {@link #onStart()}
 *  <li> {@link #onResume()}
 *  <li> Fragment is active
 *  <li> {@link #onPause()}
 *  <li> {@link #onStop()}
 *  <li> {@link #onDestroyView()}
 *  <li> {@link #onDestroy()}
 *  <li> {@link #onDetach()}
 *  <li> Fragment is destroyed
 * </ul>
 */
public abstract class Fragment extends android.support.v4.app.Fragment {
    private AppCompatActivity mActivity;

    @Nullable
    @Bind(R2.id.toolbar)
    protected Toolbar mToolbar;

    @Override
    public void onAttach(Context context) {
        if (context instanceof AppCompatActivity) {
            super.onAttach(context);
            mActivity = (AppCompatActivity) context;
        } else {
            throw new IllegalArgumentException("Cannot attach fragment to activity. Activity must be extend AppCompatActivity");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    @CallSuper
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mToolbar != null) {
            mActivity.setSupportActionBar(mToolbar);
            ActionBar actionBar = mActivity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    @CallSuper
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    /**
     * Change the title associated with this activity of this fragment. If this is a
     * top-level activity, the title for its window will change. If it
     * is an embedded activity, the parent can do whatever it wants
     * with it.
     */
    protected void setTitle(@StringRes int resId) {
        mActivity.setTitle(resId);
    }

    /**
     * Change the title associated with this activity of this fragment. If this is a
     * top-level activity, the title for its window will change. If it
     * is an embedded activity, the parent can do whatever it wants
     * with it.
     */
    protected void setTitle(CharSequence title) {
        mActivity.setTitle(title);
    }

    /**
     * Set whether an activity title/subtitle should be displayed.
     *
     * <p>
     * See {@link ActionBar#setDisplayShowTitleEnabled(boolean)}
     * for more details.
     * </p>
     *
     * @param enabled true to display a title/subtitle if present.
     */
    protected void setTitleEnabled(boolean enabled) {
        ActionBar actionBar = mActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(enabled);
        }
    }

    /**
     * Return the current fragment layout id.
     */
    @LayoutRes
    public abstract int getLayoutId();
}
