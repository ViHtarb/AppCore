package com.appcore.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcore.R;

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
public abstract class ListFragment extends Fragment {

    @Nullable
    protected SwipeRefreshLayout mRefreshLayout;
    protected RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        if (view != null) {
            mRefreshLayout = view.findViewById(R.id.refresh_layout);
            mRecyclerView = view.findViewById(R.id.recycler_view);

            if (mRefreshLayout != null) {
                mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ListFragment.this.onRefresh();
                    }
                });
            }

            if (mRecyclerView != null) {
                mRecyclerView.setAdapter(getAdapter());
            } else {
                throw new IllegalStateException("Required view 'R.id.recycler_view' with ID " + R.id.recycler_view + " for field 'mRecyclerView' was not found.");
            }
        }

        return view;
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