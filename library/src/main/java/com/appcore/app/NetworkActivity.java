package com.appcore.app;

import android.support.annotation.CallSuper;

import com.appcore.net.Network;

/**
 * Base implementation of {@link Activity} with implemented
 * {@link Network#register(Object)} and {@link Network#unregister(Object)}
 * this activity in {@link Network}
 *
 * @see Network
 */
public abstract class NetworkActivity extends Activity {

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        Network.register(this);
    }

    @Override
    @CallSuper
    protected void onStop() {
        Network.unregister(this);
        super.onStop();
    }
}
