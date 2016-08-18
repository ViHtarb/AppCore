package com.appcore.sample;

import android.util.Log;

import com.appcore.app.NetworkActivity;
import com.appcore.sample.net.Network;

public class MainActivity extends NetworkActivity {
    private Network mNetwork = Network.getInstance();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("TEST", String.valueOf(Network.isRegistered(this)));
    }
}
