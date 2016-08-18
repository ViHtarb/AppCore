package com.appcore.fragments;

import android.support.annotation.CallSuper;

import com.appcore.net.Network;

/**
 * Base implementation of {@link Fragment} with already implemented
 * {@link Network#register(Object)} and {@link Network#unregister(Object)}
 * this fragment in {@link Network}
 *
 * @see Network
 */
public abstract class NetworkFragment extends Fragment {

    @Override
    @CallSuper
    public void onStart() {
        super.onStart();
        Network.register(this);
    }

    @Override
    @CallSuper
    public void onStop() {
        Network.unregister(this);
        super.onStop();
    }
}
