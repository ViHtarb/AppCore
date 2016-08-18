package com.appcore.widget.adapters;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
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
                    if (!mSelectedPositions.isEmpty()) {
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
            if (!isSelected && isSelectable()) {
                view.setSelected(true);
                mSelectedPositions.add(position);

                if (mOnItemSelectedListener != null) {
                    mOnItemSelectedListener.onItemSelected(view, getItem(position), position);
                }
            }
            super.onClick(view);
        }

        public boolean isSelectable() {
            return true;
        }
    }

    public SelectableAdapter(Context context) {
        super(context);
    }

    @Override
    @CallSuper
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(VH holder, int position) {
        holder.itemView.setSelected(mSelectedPositions.contains(position));
    }

    @Override
    @CallSuper
    public void removeItem(int position) {
        mSelectedPositions.remove(position);

        super.removeItem(position);
    }

    @Override
    @CallSuper
    public void clear() {
        mSelectedPositions.clear();

        super.clear();
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
        if (position != RecyclerView.NO_POSITION && position < getItemCount()) {
            VH viewHolder = getViewHolder(position);
            if (viewHolder != null && viewHolder.isSelectable()) {
                switch (mChoiceMode) {
                    case SINGLE:
                        if (!mSelectedPositions.isEmpty() && mSelectedPositions.first() != position) {
                            VH selectedViewHolder = getViewHolder(mSelectedPositions.first());
                            selectedViewHolder.itemView.setSelected(false);

                            mSelectedPositions.clear();
                        }
                        break;
                }

                View view = viewHolder.itemView;
                if (!view.isSelected()) {
                    view.setSelected(true);

                    mSelectedPositions.add(position);

                    if (notify && mOnItemSelectedListener != null) {
                        mOnItemSelectedListener.onItemSelected(view, getItem(position), position);
                    }
                }
            }
        }
    }

    public void clearSelection() {
        for (Integer position : mSelectedPositions) {
            VH selectedViewHolder = getViewHolder(position);
            selectedViewHolder.itemView.setSelected(false);
        }

        mSelectedPositions.clear();
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

    public void setOnItemSelectedListener(OnItemSelectedListener<T> listener) {
        mOnItemSelectedListener = listener;
    }
}
