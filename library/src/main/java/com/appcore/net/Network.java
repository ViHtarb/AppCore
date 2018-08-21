package com.appcore.net;

import com.squareup.otto.Bus;

import androidx.annotation.NonNull;

/**
 * Created by Viнt@rь on 16.05.2016
 */
public abstract class Network {
    private static final Bus BUS = new Bus();

    /**
     * Registers all handler methods on {@code object} to receive events and producer methods to provide events.
     *
     * @see Bus#register(Object)
     */
    public static void register(@NonNull Object object) {
        BUS.register(object);
    }

    /**
     * Unregisters all producer and handler methods on a registered {@code object}.
     *
     * @see Bus#unregister(Object)
     */
    public static void unregister(@NonNull Object object) {
        BUS.unregister(object);
    }

    /**
     * Posts an event to all registered handlers. This method will return successfully after the event has been posted to
     * all handlers, and regardless of any exceptions thrown by handlers.
     *
     * @see Bus#post(Object)
     */
    protected void post(Object event) {
        BUS.post(event);
    }
}