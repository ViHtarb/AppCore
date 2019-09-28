package com.appcore.fragments;

import android.os.Bundle;
import android.view.View;

import com.appcore.R;

import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * Base implementation of {@link Fragment} with implemented binding
 * {@link SwipeRefreshLayout} and {@link RecyclerView} to this fragment.
 *
 * <p>
 * Fragment already has layout {@link R.layout#fragment_list} which
 * contains {@link SwipeRefreshLayout} with id {@link R.id#refresh_layout}
 * and {@link RecyclerView} with id {@link R.id#recycler_view}.
 * </p>
 *
 * <p>
 * For implement custom layout your need override constructor with custom layout id
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
public abstract class ListFragment extends Fragment {

    @Nullable
    protected SwipeRefreshLayout mRefreshLayout;
    protected RecyclerView mRecyclerView;

    public ListFragment() {
        super(R.layout.fragment_list);
    }

    @ContentView
    public ListFragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(getAdapter());
        } else {
            throw new IllegalStateException("appcore:ListFragment: Required view 'R.id.recycler_view' with ID " + R.id.recycler_view + " for field 'mRecyclerView' was not found.");
        }

        mRefreshLayout = view.findViewById(R.id.refresh_layout);
        if (mRefreshLayout != null) {
            mRefreshLayout.setOnRefreshListener(this::onRefresh);
        }
    }

    protected void onRefresh() {

    }

    /**
     * Notify the {@link SwipeRefreshLayout}(if present in layout) that refresh state has changed. Do not call this when
     * refresh is triggered by a swipe gesture.
     *
     * <p>
     * See {@link SwipeRefreshLayout#setRefreshing(boolean)} for more details.
     * </p>
     */
    protected void setRefreshing(boolean refreshing) {
        if (mRefreshLayout != null) {
            mRefreshLayout.setRefreshing(refreshing);
        }
    }

    /**
     * Return the adapter extend {@link RecyclerView.Adapter}.
     */
    protected abstract RecyclerView.Adapter getAdapter();
}