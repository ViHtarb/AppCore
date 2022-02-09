package com.appcore.widget.adapters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;

/**
 * Created by Viнt@rь on 24.08.2016
 */
public class SimpleCacheProvider<T> implements CacheProvider<T> {
    protected final Set<T> mCache = new HashSet<>();

    @Override
    public boolean isEmpty() {
        return mCache.isEmpty();
    }

    @Override
    public boolean contains(@NonNull T item) {
        return !isEmpty() && mCache.contains(item);
    }

    @Override
    public int size() {
        return mCache.size();
    }

    @Override
    public void add(@NonNull T item) {
        mCache.add(item);
    }

    @Override
    public void add(@NonNull Collection<T> collection) {
        mCache.addAll(collection);
    }

    @Override
    public void update(@NonNull T item) {
        if (contains(item)) {
            mCache.remove(item);
            mCache.add(item);
        }
    }

    @Override
    public void remove(@NonNull T item) {
        mCache.remove(item);
    }

    @Override
    public void clear() {
        mCache.clear();
    }

    @Override
    public List<T> getCache() {
        return new ArrayList<>(mCache);
    }
}