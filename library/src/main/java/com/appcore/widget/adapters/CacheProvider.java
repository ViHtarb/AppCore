package com.appcore.widget.adapters;

import android.support.annotation.NonNull;

import java.util.Collection;

/**
 * Created by Viнt@rь on 24.08.2016
 *
 * TODO think about update method
 */
public interface CacheProvider<T> {

    boolean isEmpty();
    boolean contains(@NonNull T item);

    int size();

    void add(@NonNull T item);
    void add(@NonNull Collection<T> collection);
    void remove(@NonNull T item);

    Collection<T> getCache();
}