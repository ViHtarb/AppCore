package com.appcore.sample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appcore.fragments.ListFragment;
import com.appcore.sample.R;
import com.appcore.widget.adapters.CacheProvider;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;
//import butterknife.BindView;

/**
 * Created by Viнt@rь on 19.08.2019
 */
public class TestCollapsingFragment extends ListFragment {

    //@BindView(R.id.image)
    //ImageView mImageView;

    private Adapter mAdapter;

    public TestCollapsingFragment() {
        super(R.layout.fragment_test_collapsing);
    }

    @Override
    protected Adapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new Adapter(requireContext());
        }
        return mAdapter;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        //mImageView.setImageURL("https://st2.depositphotos.com/2001755/5408/i/450/depositphotos_54081723-stock-photo-beautiful-nature-landscape.jpg");
        if (mAdapter.isEmpty()) {

            List<String> items = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                items.add(String.valueOf(i));
            }
            mAdapter.add(items);

            /*mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    Log.d("TEST", String.format("%d, %d", dx, dy));
                }
            });*/
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        Navigation.findNavController(requireActivity(), R.id.navigation_host_fragment)
                .navigate(TestCollapsingFragmentDirections.actionToTestFragment(0));

        inflater.inflate(R.menu.test, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireActivity(), R.id.navigation_host_fragment))
                || super.onOptionsItemSelected(item);
    }

    public static final class Adapter extends com.appcore.widget.adapters.Adapter<Adapter.ViewHolder, String> {

        public Adapter(@NonNull Context context) {
            super(context);
        }

        public Adapter(@NonNull Context context, CacheProvider<String> cacheProvider) {
            super(context, cacheProvider);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(getInflater().inflate(R.layout.item_test, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.mTextView.setText(getItem(position));
        }

        final class ViewHolder extends com.appcore.widget.adapters.Adapter.ViewHolder {

            //@BindView(R.id.test_text)
            TextView mTextView;

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
