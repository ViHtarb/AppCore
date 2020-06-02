package com.appcore.sample;

import android.util.Log;

import com.appcore.sample.net.Network;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {
    private Network mNetwork = Network.getInstance();

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        Log.d("TEST", "onBackPressed");
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d("TEST", "onSupportNavigateUp");
        return Navigation.findNavController(this, R.id.navigation_host_fragment).navigateUp()
                || super.onSupportNavigateUp();
    }

    /*    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }*/

/*    @Override
    protected void onStart() {
        super.onStart();
        Network.register(this);
    }

    @Override
    protected void onStop() {
        Network.unregister(this);
        super.onStop();
    }*/

/*    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.navigation_host_fragment).navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);

        //NavigationUI.setupWithNavController(toolbar, Navigation.findNavController(this, R.id.navigation_host_fragment));
    }*/
}