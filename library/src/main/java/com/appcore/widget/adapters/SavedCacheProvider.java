package com.appcore.widget.adapters;

import androidx.annotation.NonNull;

/**
 * Created by Viнt@rь on 28.08.2016
 *
 * @deprecated Use {@link StoredCacheProvider} instead.
 */
@Deprecated
public class SavedCacheProvider<T> extends StoredCacheProvider<T> {

    public SavedCacheProvider(@NonNull String name) {
        super(name);
    }
}