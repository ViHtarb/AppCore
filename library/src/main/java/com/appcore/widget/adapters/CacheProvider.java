package com.appcore.widget.adapters;

import java.util.Collection;

import androidx.annotation.NonNull;

/**
 * Created by Viнt@rь on 24.08.2016
 */
public interface CacheProvider<T> {

    boolean isEmpty();
    boolean contains(@NonNull T item);

    int size();

    void add(@NonNull T item);
    void add(@NonNull Collection<T> collection);
    void update(@NonNull T item);
    void remove(@NonNull T item);

    void clear();

    Collection<T> getCache();
}