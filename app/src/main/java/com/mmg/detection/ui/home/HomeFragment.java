package com.mmg.detection.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mmg.detection.R;
import com.mmg.detection.databinding.FragmentHomeBinding;
import com.mmg.detection.ui.base.BaseAdapter;
import com.mmg.detection.ui.base.BaseViewModel;
import com.mmg.detection.ui.base.NormalAdapter;
import com.mmg.detection.ui.base.NormalFragment;

import java.util.List;
import androidx.lifecycle.ViewModelProviders;

public class HomeFragment extends NormalFragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }
//
//    @Override
//    protected BaseAdapter crateAdapter() {
//        return null;
//    }
//
//    @Override
//    protected BaseViewModel crateViewModel() {
//        return null;
//    }
    @Override
    protected BaseAdapter crateAdapter() {
    return new NormalAdapter(getContext());
    }

    @Override
    protected BaseViewModel crateViewModel() {
        return ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    protected List<Pair<String, String>> getNormalInfo() {
        return ((HomeViewModel) viewModel).getHookInfo(getContext()
        );
    }
}