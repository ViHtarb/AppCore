package com.appcore.widget.adapters;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Viнt@rь on 24.08.2016
 */
public class SimpleCacheProvider<T> implements CacheProvider<T> {
    protected final Set<T> mCache = new HashSet<>();

    @Override
    public int size() {
        return mCache.size();
    }

    @Override
    public boolean isEmpty() {
        return mCache.isEmpty();
    }

    @Override
    public boolean contains(@NonNull T item) {
        return mCache.contains(item);
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
    public void remove(@NonNull T item) {
        mCache.remove(item);
    }

    @Override
    public List<T> getCache() {
        return new ArrayList<>(mCache);
    }
}
