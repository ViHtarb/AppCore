package com.appcore.widget.adapters;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Viнt@rь on 03.08.2016
 */
public abstract class SelectableAdapter<VH extends SelectableAdapter.ViewHolder, T> extends Adapter<VH, T> {

    public enum ChoiceMode {
        SINGLE,
        MULTIPLE
    }

    protected final TreeSet<Integer> mSelectedPositions = new TreeSet<>();

    protected ChoiceMode mChoiceMode = ChoiceMode.MULTIPLE;
    protected OnItemSelectedListener<T> mOnItemSelectedListener;

    public abstract class ViewHolder extends Adapter.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            boolean isSelected = view.isSelected();
            switch (mChoiceMode) {
                case SINGLE:
                    if (!mSelectedPositions.isEmpty() && mSelectedPositions.first() != position) {
                        VH viewHolder = getViewHolder(mSelectedPositions.first());
                        if (viewHolder != null) {
                            viewHolder.itemView.setSelected(false);
                        }

                        mSelectedPositions.clear();
                    }
                    break;
                case MULTIPLE:
                    if (isSelected) {
                        view.setSelected(false);
                        mSelectedPositions.remove(position);
                    }
                    break;
            }

            T item = getItem(position);
            if (!isSelected && isItemSelectable(item)) {
                view.setSelected(true);
                mSelectedPositions.add(position);

                if (mOnItemSelectedListener != null) {
                    mOnItemSelectedListener.onItemSelected(view, item, position);
                }
            }
            super.onClick(view);
        }
    }

    public SelectableAdapter(Context context) {
        super(context);
    }

    @Override
    public void add(@NonNull T item) {
        super.add(item);
        invalidateSelection(item);
    }

    @Override
    public void add(@NonNull Collection<T> items) {
        super.add(items);
        if (!mSelectedPositions.isEmpty()) {
            for (T item : items) {
                invalidateSelection(item);
            }
        }
    }

    @Override
    public void remove(int position) {
        mSelectedPositions.remove(position);
        invalidateSelection(position, true);
        super.remove(position);
    }

    @Override
    public void remove(@NonNull T item) {
        int position = mItems.indexOf(item);
        mSelectedPositions.remove(position);
        invalidateSelection(position, true);
        super.remove(item);
    }

    @Override
    public void clear() {
        mSelectedPositions.clear();
        super.clear();
    }

    @Override
    @CallSuper
    public void onBindViewHolder(VH holder, int position) {
        holder.itemView.setSelected(mSelectedPositions.contains(position));
    }

    public ChoiceMode getChoiceMode() {
        return mChoiceMode;
    }

    public void setChoiceMode(@NonNull ChoiceMode choiceMode) {
        if (mChoiceMode != choiceMode) {
            mChoiceMode = choiceMode;

            clearSelection();
        }
    }

    public boolean isItemSelectable(int position) {
        return isItemSelectable(getItem(position));
    }

    public boolean isItemSelectable(@NonNull T item) {
        return true;
    }

    public int getSelectedItemsCount() {
        return mSelectedPositions.size();
    }

    public List<T> getSelectedItems() {
        List<T> selectedItems = new ArrayList<>();
        for (Integer position : mSelectedPositions) {
            selectedItems.add(getItem(position));
        }
        return selectedItems;
    }

    public void setItemSelected(T item) {
        if (contains(item)) {
            setItemSelected(mItems.indexOf(item));
        }
    }

    public void setItemSelected(T item, boolean notify) {
        if (contains(item)) {
            setItemSelected(mItems.indexOf(item), notify);
        }
    }

    public void setItemSelected(int position) {
        setItemSelected(position, false);
    }

    public void setItemSelected(int position, boolean notify) {
        if (position != RecyclerView.NO_POSITION && position < getItemCount() && isItemSelectable(position)) {
            switch (mChoiceMode) {
                case SINGLE:
                    if (!mSelectedPositions.isEmpty() && mSelectedPositions.first() != position) {
                        VH viewHolder = getViewHolder(mSelectedPositions.first());
                        if (viewHolder != null) {
                            viewHolder.itemView.setSelected(false);
                        }

                        mSelectedPositions.clear();
                    }
                    break;
            }

            if (!mSelectedPositions.contains(position)) {
                View view = null;

                VH viewHolder = getViewHolder(position);
                if (viewHolder != null) {
                    view = viewHolder.itemView;
                    view.setSelected(true);
                }

                mSelectedPositions.add(position);

                if (notify && mOnItemSelectedListener != null) {
                    mOnItemSelectedListener.onItemSelected(view, getItem(position), position);
                }
            }
        }
    }

    public void selectAll() {
        if (mChoiceMode == ChoiceMode.MULTIPLE) {
            for (int i = 0; i < getItemCount(); i++) {
                if (isItemSelectable(i)) {
                    mSelectedPositions.add(i);

                    VH viewHolder = getViewHolder(i);
                    if (viewHolder != null) {
                        viewHolder.itemView.setSelected(true);
                    }
                }
            }
        }
    }

    public void clearSelection() {
        for (Integer position : mSelectedPositions) {
            VH viewHolder = getViewHolder(position);
            if (viewHolder != null) {
                viewHolder.itemView.setSelected(false);
            }
        }

        mSelectedPositions.clear();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener<T> listener) {
        mOnItemSelectedListener = listener;
    }

    private void invalidateSelection(T item) {
        invalidateSelection(item, false);
    }

    private void invalidateSelection(T item, boolean afterRemove) {
        if (!mSelectedPositions.isEmpty()) {
            invalidateSelection(mItems.indexOf(item), afterRemove);
        }
    }

    private void invalidateSelection(int index) {
        invalidateSelection(index, false);
    }

    private void invalidateSelection(int index, boolean afterRemove) {
        if (!mSelectedPositions.isEmpty()) {
            TreeSet<Integer> selectedPositions = new TreeSet<>(mSelectedPositions);

            mSelectedPositions.clear();
            for (Integer position : selectedPositions) {
                mSelectedPositions.add(position >= index ? afterRemove ? position - 1 : position + 1 : position);
            }
            notifyDataSetChanged();
        }
    }
}