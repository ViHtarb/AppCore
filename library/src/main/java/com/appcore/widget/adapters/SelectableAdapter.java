package com.appcore.widget.adapters;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Viнt@rь on 03.08.2016
 * <p>
 * Reimplemented to using {@link SelectionTracker} instead internal selection implementation.
 *
 * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
 */
@Deprecated
public abstract class SelectableAdapter<VH extends SelectableAdapter.ViewHolder, T extends Parcelable> extends Adapter<VH, T> {

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public enum ChoiceMode {

        @Deprecated SINGLE,
        @Deprecated MULTIPLE
    }

    @Deprecated
    protected ChoiceMode mChoiceMode = ChoiceMode.MULTIPLE;

    @Deprecated
    protected OnItemSelectedListener<T> mOnItemSelectedListener;

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public abstract class ViewHolder extends Adapter.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        private Details getItemDetails() {
            return new Details(getAdapterPosition(), getItem(getAdapterPosition()));
        }
    }

    private SelectionTracker<T> mSelectionTracker;

    public SelectableAdapter(Context context) {
        super(context);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

        mSelectionTracker = new SelectionTracker.Builder<>("selection-" + UUID.randomUUID().toString(), recyclerView,
                new KeyProvider(),
                new ItemDetailsLookupImpl(recyclerView),
                StorageStrategy.createParcelableStorage(clazz))
                .withSelectionPredicate(new SelectionTracker.SelectionPredicate<T>() {
                    @Override
                    public boolean canSetStateForKey(@NonNull T key, boolean nextState) {
                        return isItemSelectable(key);
                    }

                    @Override
                    public boolean canSetStateAtPosition(int position, boolean nextState) {
                        return isItemSelectable(position);
                    }

                    @Override
                    public boolean canSelectMultiple() {
                        return mChoiceMode == ChoiceMode.MULTIPLE;
                    }
                })
                .build();

        mSelectionTracker.addObserver(new SelectionTracker.SelectionObserver<T>() {

            @Override
            public void onItemStateChanged(@NonNull T key, boolean selected) {
                if (mOnItemSelectedListener != null) {
                    mOnItemSelectedListener.onItemSelected(null, key, mItems.indexOf(key));
                }
            }
        });
    }

    @Override
    @CallSuper
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.itemView.setActivated(mSelectionTracker.isSelected(getItem(position)));
    }

    /**
     * Preserves selection, if any. Call this method from Activity#onSaveInstanceState
     *
     * @param state Bundle instance supplied to onSaveInstanceState.
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void onSaveInstanceState(Bundle state) {
        mSelectionTracker.onSaveInstanceState(state);
    }

    /**
     * Restores selection from previously saved state. Call this method from
     * Activity#onCreate.
     *
     * @param state Bundle instance supplied to onCreate.
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void onRestoreInstanceState(Bundle state) {
        mSelectionTracker.onRestoreInstanceState(state);
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public ChoiceMode getChoiceMode() {
        return mChoiceMode;
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void setChoiceMode(@NonNull ChoiceMode choiceMode) {
        if (mChoiceMode != choiceMode) {
            mChoiceMode = choiceMode;

            clearSelection();
        }
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public boolean isItemSelectable(int position) {
        return isItemSelectable(getItem(position));
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public boolean isItemSelectable(@NonNull T item) {
        return true;
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public int getSelectedItemsCount() {
        return mSelectionTracker.getSelection().size();
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public List<T> getSelectedItems() {
        List<T> selectedItems = new ArrayList<>();
        for (T item : mSelectionTracker.getSelection()) {
            selectedItems.add(item);
        }
        return selectedItems;
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void setItemSelected(int position) {
        setItemSelected(position, false);
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void setItemSelected(int position, boolean notify) {
        if (position != RecyclerView.NO_POSITION && position < getItemCount()) {
            setItemSelected(getItem(position), notify);
        }
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void setItemSelected(T item) {
        setItemSelected(item, false);
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void setItemSelected(T item, boolean notify) {
        if (contains(item)) {
            mSelectionTracker.select(item);
        }
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void selectAll() {
        if (mChoiceMode == ChoiceMode.MULTIPLE) {
            for (int i = 0; i < getItemCount(); i++) {
                mSelectionTracker.select(getItem(i));
            }
        }
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void clearSelection() {
        mSelectionTracker.clearSelection();
    }

    /**
     * @deprecated Use {@link Adapter} and {@link SelectionTracker} instead.
     */
    @Deprecated
    public void setOnItemSelectedListener(OnItemSelectedListener<T> listener) {
        mOnItemSelectedListener = listener;
    }

    private final class KeyProvider extends ItemKeyProvider<T> {

        private KeyProvider() {
            super(SCOPE_CACHED);
        }

        @Nullable
        @Override
        public T getKey(int position) {
            return getItem(position);
        }

        @Override
        public int getPosition(@NonNull T key) {
            return mItems.indexOf(key);
        }
    }

    private final class Details extends ItemDetailsLookup.ItemDetails<T> {

        private final int mPosition;
        private final T mItem;

        private Details(int position, @NonNull T item) {
            mPosition = position;
            mItem = item;
        }

        @Override
        public int getPosition() {
            return mPosition;
        }

        @Override
        public T getSelectionKey() {
            return mItem;
        }

        @Override
        public boolean inSelectionHotspot(@NonNull MotionEvent e) {
            return true;
        }
    }

    private final class ItemDetailsLookupImpl extends ItemDetailsLookup<T> {

        private final RecyclerView mRecyclerView;

        private ItemDetailsLookupImpl(RecyclerView recyclerView) {
            mRecyclerView = recyclerView;
        }

        @SuppressWarnings("unchecked")
        @Nullable
        @Override
        public Details getItemDetails(@NonNull MotionEvent e) {
            View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(view);
                if (holder instanceof SelectableAdapter.ViewHolder) {
                    return ((SelectableAdapter<VH, T>.ViewHolder) holder).getItemDetails();
                }
            }
            return null;
        }
    }
}