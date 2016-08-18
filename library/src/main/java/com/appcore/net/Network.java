package com.appcore.net;

import android.support.annotation.NonNull;

import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viнt@rь on 16.05.2016
 */
public abstract class Network {
    private static final Bus sBus = new Bus();
    private static final List<Object> sRegistered = new ArrayList<>();

    /**
     * Register handler for events
     */
    public static synchronized void register(@NonNull Object object) {
        if (!isRegistered(object)) {
            sRegistered.add(object);
            sBus.register(object);
        }
    }

    /**
     * Unregister handler from events
     */
    public static synchronized void unregister(@NonNull Object object) {
        if (isRegistered(object)) {
            sRegistered.remove(object);
            sBus.unregister(object);
        }
    }

    /**
     * Check is object registered for events
     */
    public static synchronized boolean isRegistered(@NonNull Object object) {
        return sRegistered.contains(object);
    }

    /**
     * Check is class registered for events
     */
    public static synchronized boolean isRegistered(@NonNull Class clazz) {
        for (Object object : sRegistered) {
            Class objectClass = object.getClass();
            if (objectClass.equals(clazz)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Post events to all registered handlers.
     *
     * <p>
     * See {@link Bus#post(Object)} for more details.
     * </p>
     */
    protected void post(Object event) {
        sBus.post(event);
    }
}
