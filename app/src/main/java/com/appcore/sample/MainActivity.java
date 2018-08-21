package com.appcore.sample;

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
        openFragment(new TestFragment());
    }

    @Override
    protected void onStop() {
        Network.unregister(this);
        super.onStop();
    }
}
