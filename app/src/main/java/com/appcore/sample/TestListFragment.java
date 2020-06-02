package com.appcore.sample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.appcore.fragments.ListFragment;
//import com.appcore.sample.databinding.FragmentTestList2Binding;
//import com.appcore.sample.databinding.ItemTestBinding;
import com.appcore.widget.adapters.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Viнt@rь on 28.09.2019
 */
public final class TestListFragment {/*extends ListFragment {

    private TestAdapter mAdapter;
    //private FragmentTestList2Binding mBinding;

    public TestListFragment() {
        super(R.layout.fragment_test_list_2);
    }

    @Override
    protected TestAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new TestAdapter(requireContext());

            for (int i = 0; i < 10; i++) {
                mAdapter.add(String.format("Item %s", i));
            }
        }
        return mAdapter;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //mBinding = FragmentTestList2Binding.bind(view);
    }

    private static final class TestAdapter extends Adapter<TestAdapter.ViewHolder, String> {

        public TestAdapter(@NonNull Context context) {
            super(context);
        }

        @NonNull
        @Override
        public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TestAdapter.ViewHolder(ItemTestBinding.inflate(getInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, int position) {
            holder.mBinding.testText.setText(getItem(position));
        }

        final class ViewHolder extends Adapter.ViewHolder {

            protected final ItemTestBinding mBinding;

            public ViewHolder(ItemTestBinding itemTestBinding) {
                super(itemTestBinding.getRoot());

                mBinding = itemTestBinding;
            }
        }
    }*/
}
