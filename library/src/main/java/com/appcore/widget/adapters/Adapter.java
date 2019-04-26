package com.appcore.widget.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

/**
 * Created by Viнt@rь on 06.11.2015
 *
 * TODO think about remove {@link Adapter#sort()} and {@link Adapter#getComparator()} methods
 * TODO think about add item update(index) method
 * TODO think about applying cache data if cache provider is presents
 */
public abstract class Adapter<VH extends RecyclerView.ViewHolder, T> extends RecyclerView.Adapter<VH> {
    private final Context mContext;
    private final LayoutInflater mInflater;

    protected final List<T> mItems = new ArrayList<>();

    protected final CacheProvider<T> mCacheProvider;

    protected RecyclerView mRecyclerView;

    protected OnItemClickListener<T> mOnItemClickListener;
    protected OnItemLongClickListener<T> mOnItemLongClickListener;

    public abstract class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this::onClick);
            itemView.setOnLongClickListener(this::onLongClick);

            ButterKnife.bind(this, itemView);
        }

        @CallSuper
        protected void onClick(View view) {
            if (mOnItemClickListener != null && isClickable()) {
                mOnItemClickListener.onItemClick(view, getCurrentItem(), getAdapterPosition());
            }
        }

        @CallSuper
        protected boolean onLongClick(View view) {
            return mOnItemLongClickListener != null && isClickable() && mOnItemLongClickListener.onItemLongClick(view, getCurrentItem(), getAdapterPosition());
        }

        public boolean isClickable() {
            return true;
        }

        private T getCurrentItem() {
            return getItem(getAdapterPosition());
        }
    }

    public Adapter(@NonNull Context context) {
        this(context, null);
    }

    public Adapter(@NonNull Context context, CacheProvider<T> cacheProvider) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mCacheProvider = cacheProvider;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public long getItemId(int position) {
        return hasStableIds() ? getItem(position).hashCode() : super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    protected Context getContext() {
        return mContext;
    }

    protected LayoutInflater getInflater() {
        return mInflater;
    }

    protected Resources getResources() {
        return mContext.getResources();
    }

    protected int getColor(@ColorRes int resId) {
        return ResourcesCompat.getColor(getResources(), resId, mContext.getTheme());
    }

    protected String getString(@StringRes int resId) {
        return mContext.getString(resId);
    }

    protected String getString(@StringRes int resId, Object... formatArgs) {
        return mContext.getString(resId, formatArgs);
    }

    protected Drawable getDrawable(@DrawableRes int resId) {
        return ResourcesCompat.getDrawable(getResources(), resId, mContext.getTheme());
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        mOnItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> listener) {
        mOnItemLongClickListener = listener;
    }

    public boolean isEmpty() {
        return mItems.isEmpty();
    }

    public boolean contains(T item) {
        return mItems.contains(item);
    }

    public T getItem(int position) {
        if (position >= getItemCount() || position == RecyclerView.NO_POSITION) {
            return null;
        }
        return mItems.get(position);
    }

    public List<T> getItems() {
        return new ArrayList<>(mItems);
    }

    public void add(@NonNull T item) {
        mItems.add(item);
        notifyItemInserted(mItems.indexOf(item));

        if (mCacheProvider != null && isItemCacheble(item)) {
            mCacheProvider.add(item);
        }
    }

    public void add(@NonNull Collection<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();

        if (mCacheProvider != null) {
            List<T> cachebleItems = new ArrayList<>();
            for (T item : items) {
                if (isItemCacheble(item)) {
                    cachebleItems.add(item);
                }
            }
            mCacheProvider.add(cachebleItems);
        }
    }

    public void update(@NonNull T item) {
        if (mItems.contains(item)) {
            int index = mItems.indexOf(item);
            mItems.set(index, item);

            notifyItemChanged(index);

            if (mCacheProvider != null && isItemCached(item)) {
                mCacheProvider.update(item);
            }
        }
    }

    public void remove(int position) {
        if (mCacheProvider != null) {
            mCacheProvider.remove(getItem(position));
        }

        removeItemInternal(position);
    }

    public void remove(@NonNull T item) {
        removeItemInternal(mItems.indexOf(item));

        if (mCacheProvider != null) {
            mCacheProvider.remove(item);
        }
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public void sort() {
        Comparator<T> comparator = getComparator();
        if (comparator != null) {
            sort(comparator);
        }
    }

    public void sort(@NonNull Comparator<T> comparator) {
        Collections.sort(mItems, comparator);
        notifyDataSetChanged();
    }

    @Nullable
    protected Comparator<T> getComparator() {
        return null;
    }

    @Nullable
    @SuppressWarnings("unchecked")
    protected <CP extends CacheProvider<T>> CP getCacheProvider() {
        return (CP) mCacheProvider;
    }

    /**
     * @deprecated This method not longer needed.
     */
    @Nullable
    @SuppressWarnings("unchecked")
    @Deprecated
    protected VH getViewHolder(int position) {
        return (VH) mRecyclerView.findViewHolderForAdapterPosition(position);
    }

    protected boolean isItemCached(int position) {
        return isItemCached(getItem(position));
    }

    protected boolean isItemCached(@NonNull T item) {
        return mCacheProvider != null && mCacheProvider.contains(item);
    }

    protected boolean isItemCacheble(int position) {
        return isItemCacheble(getItem(position));
    }

    protected boolean isItemCacheble(@NonNull T item) {
        return mCacheProvider != null;
    }

    protected void removeItemInternal(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }
}