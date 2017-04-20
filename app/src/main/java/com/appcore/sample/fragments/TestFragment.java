package com.appcore.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcore.fragments.Fragment;
import com.appcore.sample.R;

/**
 * Created by Viнt@rь on 20.04.2017
 */
public class TestFragment extends Fragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        Log.d("TEST", "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("TEST", "onViewCreated");
    }
}
