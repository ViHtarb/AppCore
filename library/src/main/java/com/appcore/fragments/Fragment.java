package com.appcore.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcore.R;

import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Base implementation of {@link androidx.fragment.app.Fragment} with using {@link ButterKnife}
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
public abstract class Fragment extends androidx.fragment.app.Fragment {
    private AppCompatActivity mActivity;

    @Nullable
    protected Toolbar mToolbar;

    private Unbinder mUnBinder;

    public Fragment() {
        super();
    }

    @ContentView
    public Fragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof AppCompatActivity) {
            super.onAttach(context);
            mActivity = (AppCompatActivity) context;
        } else {
            throw new IllegalArgumentException("Cannot attach fragment to activity. Activity "
                    + context + " must be extend AppCompatActivity");
        }
    }

    @Nullable
    @Override
    @CallSuper
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;

        if (getLayoutId() == View.NO_ID) {
            view = super.onCreateView(inflater, container, savedInstanceState);
        } else {
            view = inflater.inflate(getLayoutId(), null);
        }
        mUnBinder = ButterKnife.bind(this, view);

        mToolbar = view.findViewById(R.id.toolbar);
        if (mToolbar != null) {
            mActivity.setSupportActionBar(mToolbar);
        }

        return view;
    }

    @Override
    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }

    /**
     * Set whether home should be displayed as an "up" affordance.
     * Set this to true if selecting "home" returns up by a single level in your UI
     * rather than back to the top level or front page.
     *
     * <p>To set several display options at once, see the setDisplayOptions methods.
     *
     * @param showHomeAsUp true to show the user that selecting home will return one
     *                     level up rather than to the top level of the app.
     *
     * @see ActionBar#setDisplayOptions(int)
     * @see ActionBar#setDisplayOptions(int, int)
     */
    protected void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        ActionBar actionBar = mActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
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
     *
     * @deprecated Use {@link #Fragment(int)} instead.
     */
    @Deprecated
    @LayoutRes
    protected int getLayoutId() {
        return View.NO_ID;
    }
}