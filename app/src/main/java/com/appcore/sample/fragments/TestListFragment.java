package com.appcore.sample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appcore.fragments.Fragment;
import com.appcore.fragments.ListFragment;
import com.appcore.sample.R;
import com.appcore.widget.adapters.Adapter;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.ChangeBounds;

/**
 * Created by Viнt@rь on 26.11.2018
 */
public final class TestListFragment extends Fragment {

    public TestListFragment() {
        super(R.layout.fragment_test_list);
    }

    /*@Override
    protected RecyclerView.Adapter getAdapter() {
        TestAdapter adapter = new TestAdapter(requireContext());
        adapter.setOnItemClickListener((view, item, position) -> {
            setSharedElementEnterTransition(new ChangeBounds());
            setSharedElementReturnTransition(new ChangeBounds());

            //testFragment.setSharedElementEnterTransition(new ChangeBounds());
            //testFragment.setSharedElementReturnTransition(new ChangeBounds());

            *//*FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                    .addSharedElement(view, "image")
                    .build();*//*
            *//*FragmentManager fragmentManager = requireFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new TestFragment())
                    .addSharedElement(view, "image")
                    .addToBackStack("test")
                    .commit();*//*
            Navigation.findNavController(requireActivity(), R.id.navigation_host_fragment).navigate(R.id.action_testListFragment_to_testFragment);
        });
        for (int i = 0; i < 100; i++) {
            adapter.add("String " + i);
        }
        return adapter;
    }*/

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TEST", "onSaveInstanceState");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.test, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
/*        switch (item.getItemId()) {
            case R.id.action_test:
*//*
                setSharedElementEnterTransition(new ChangeBounds());
                setSharedElementReturnTransition(new ChangeBounds());

                FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                        .addSharedElement(mImageView, mImageView.getTransitionName())
                        .build();
                Navigation.findNavController(requireActivity(), R.id.navigation_host_fragment).navigate(R.id.action_testListFragment_to_testFragment, null, null, extras);*//*
                break;
        }*/
        return super.onOptionsItemSelected(item);
    }

    private static final class TestAdapter extends Adapter<TestAdapter.ViewHolder, String> {

        public TestAdapter(@NonNull Context context) {
            super(context);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(parent.getContext());
            return new ViewHolder(imageView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //holder.itemView.setTransitionName("image_" + position);
            ((ImageView) holder.itemView).setImageResource(R.drawable.ic_search_black_24dp);
        }

        final class ViewHolder extends Adapter.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
