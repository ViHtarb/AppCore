package com.appcore.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.appcore.R;
import com.appcore.R2;

import butterknife.Bind;

/**
 * Base implementation of {@link NetworkFragment} with implemented binding
 * {@link SwipeRefreshLayout} and {@link RecyclerView} to this fragment.
 *
 * <p>
 * Fragment already has layout {@link R.layout#fragment_list} which
 * contains {@link SwipeRefreshLayout} with id {@link R.id#refresh_layout}
 * and {@link RecyclerView} with id {@link R.id#recycler_view}.
 * </p>
 *
 * <p>
 * For implement custom layout your need override {@link #getLayoutId()}
 * and this layout must contain {@link RecyclerView} with id {@link R.id#recycler_view}
 * {@code android:id="id/recycler_view"}.
 * </p>
 *
 * <p>
 * If you want implement custom layout with {@link SwipeRefreshLayout} then this
 * layout must contain {@link SwipeRefreshLayout} with id {@link R.id#refresh_layout}
 * {@code android:id="id/refresh_layout"}.
 * </p>
 */
public abstract class ListFragment extends NetworkFragment implements SwipeRefreshLayout.OnRefreshListener, RefreshFragment {

    @Nullable
    @Bind(R2.id.refresh_layout)
    protected SwipeRefreshLayout mRefreshLayout;

    @Bind(R2.id.recycler_view)
    protected RecyclerView mRecyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mRefreshLayout != null) {
            mRefreshLayout.setOnRefreshListener(this);
        }

        mRecyclerView.setAdapter(getAdapter());
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    /**
     * Notify the widget that refresh state has changed to refreshing.
     *
     * <p>
     * See {@link SwipeRefreshLayout#setRefreshing(boolean)} for more details.
     * </p>
     */
    protected void enableRefreshing() {
        if (mRefreshLayout != null) {
            mRefreshLayout.setRefreshing(true);
        }
    }

    /**
     * Notify the widget that refresh state has changed to stop refreshing.
     *
     * <p>
     * See {@link SwipeRefreshLayout#setRefreshing(boolean)} for more details.
     * </p>
     */
    protected void disableRefreshing() {
        if (mRefreshLayout != null) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    /**
     * Return the adapter extend {@link RecyclerView.Adapter}.
     */
    protected abstract RecyclerView.Adapter getAdapter();
}
