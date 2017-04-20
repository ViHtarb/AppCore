package com.appcore.sample;

import android.util.Log;

import com.appcore.app.Activity;
import com.appcore.sample.fragments.TestFragment;
import com.appcore.sample.net.Network;

public class MainActivity extends Activity {
    private Network mNetwork = Network.getInstance();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Network.register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("TEST", String.valueOf(Network.isRegistered(this)));

        openFragment(new TestFragment());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Network.unregister(this);
    }
}
