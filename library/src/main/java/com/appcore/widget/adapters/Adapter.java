package com.appcore.widget.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Viнt@rь on 06.11.2015
 */
public abstract class Adapter<VH extends Adapter.ViewHolder, T> extends RecyclerView.Adapter<VH> {
    private final Context mContext;
    private final LayoutInflater mInflater;

    protected final List<T> mItems = new ArrayList<>();

    protected RecyclerView mRecyclerView;

    protected OnItemClickListener<T> mOnItemClickListener;
    protected OnItemLongClickListener<T> mOnItemLongClickListener;

    public abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            ButterKnife.bind(this, itemView);
        }

        @Override
        @CallSuper
        public void onClick(View v) {
            if (mOnItemClickListener != null && isClickable()) {
                mOnItemClickListener.onItemClick(v, getCurrentItem(), getAdapterPosition());
            }
        }

        @Override
        @CallSuper
        public boolean onLongClick(View v) {
            return mOnItemLongClickListener != null && isClickable() && mOnItemLongClickListener.onItemLongClick(v, getCurrentItem(), getAdapterPosition());
        }

        public T getCurrentItem() {
            return getItem(getAdapterPosition());
        }

        public boolean isClickable() {
            return true;
        }
    }

    public Adapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public long getItemId(int position) {
        if (hasStableIds()) {
            return getItem(position).hashCode();
        }
        return super.getItemId(position);
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
        return getItemCount() == 0;
    }

    public boolean contains(T item) {
        return mItems.contains(item);
    }

    public T getItem(int position) {
        if (position >= getItemCount() || position == -1) {
            return null;
        }
        return mItems.get(position);
    }

    public List<T> getItems() {
        return mItems;
    }

    public void addItem(@NonNull T item) {
        mItems.add(item);
        sortItems();
        notifyItemInserted(mItems.indexOf(item));
    }

    public void addItem(@NonNull T item, int position) {
        mItems.add(position, item);
        sortItems();
        notifyItemInserted(mItems.indexOf(item));
    }

    public void addItems(@NonNull List<T> items) {
        mItems.addAll(items);
        sortItems();
        notifyDataSetChanged();
    }

    public void addItems(@NonNull List<T> items, int position) {
        mItems.addAll(position, items);
        sortItems();
        notifyDataSetChanged();
    }

    public void updateItem(@NonNull T item) {
        if (mItems.contains(item)) {
            int index = mItems.indexOf(item);
            mItems.remove(index);
            mItems.add(index, item);

            if (getComparator() != null) {
                sortItems();
                notifyItemChanged(mItems.indexOf(item));
            } else {
                notifyItemChanged(index);
            }
        }
    }

    public void removeItem(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    protected final void sortItems() {
        Comparator<T> comparator = getComparator();
        if (comparator != null) {
            Collections.sort(mItems, comparator);
        }
    }

    @Nullable
    protected Comparator<T> getComparator() {
        return null;
    }

    @SuppressWarnings("unchecked")
    protected VH getViewHolder(int position) {
        return (VH) mRecyclerView.findViewHolderForAdapterPosition(position);
    }
}