package com.appcore.widget.adapters;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.appcore.app.Application;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Viнt@rь on 28.08.2016
 */
public class SavedCacheProvider<T> extends SimpleCacheProvider<T> {
    private final Gson mGson = new Gson();
    private final SharedPreferences mCacheStorage = Application.getDefaultPreferences();
    private final String mName;

    public SavedCacheProvider(@NonNull String name) {
        mName = name;

        Set<T> loadedCache = mGson.fromJson(mCacheStorage.getString(mName, null), new TypeToken<Set<T>>(){}.getType());
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

    protected void save() {
        SharedPreferences.Editor editor = mCacheStorage.edit();
        editor.putString(mName, mGson.toJson(mCacheStorage)).apply();
    }
}