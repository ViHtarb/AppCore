package com.appcore.widget.adapters;

import android.content.SharedPreferences;

import com.appcore.app.Application;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collection;
import java.util.Set;

import androidx.annotation.NonNull;

/**
 * Simple provider that provide storing for cache
 */
public class StoredCacheProvider<T> extends SimpleCacheProvider<T> {
    private final Gson mGson = new Gson();
    private final SharedPreferences mStorage = Application.getDefaultPreferences();

    private final String mName;

    public StoredCacheProvider(@NonNull String name) {
        mName = name;

        Set<T> loadedCache = mGson.fromJson(mStorage.getString(mName, null), new TypeToken<Set<T>>(){}.getType());
        if (loadedCache != null) {
            mCache.addAll(loadedCache);
        }
    }

    @Override
    public void add(@NonNull T item) {
        super.add(item);
        save();
    }

    @Override
    public void add(@NonNull Collection<T> collection) {
        super.add(collection);
        save();
    }

    @Override
    public void remove(@NonNull T item) {
        super.remove(item);
        save();
    }

    @Override
    public void clear() {
        super.clear();
        save();
    }

    protected void save() {
        SharedPreferences.Editor editor = mStorage.edit();
        editor.putString(mName, mGson.toJson(mCache)).apply();
    }
}