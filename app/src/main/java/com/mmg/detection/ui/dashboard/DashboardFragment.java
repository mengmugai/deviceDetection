package com.mmg.detection.ui.dashboard;

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
import androidx.lifecycle.ViewModelProviders;

import com.mmg.detection.R;
import com.mmg.detection.databinding.FragmentDashboardBinding;
import com.mmg.detection.ui.base.BaseAdapter;
import com.mmg.detection.ui.base.BaseViewModel;
import com.mmg.detection.ui.base.NormalAdapter;
import com.mmg.detection.ui.base.NormalFragment;
import com.mmg.detection.ui.home.HomeViewModel;

import java.util.List;

public class DashboardFragment extends NormalFragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        dashboardViewModel =
//                new ViewModelProvider(this).get(DashboardViewModel.class);
//
//        binding = FragmentDashboardBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//
//    }
    @Override
    protected BaseAdapter crateAdapter() {
        return new NormalAdapter(getContext());
    }

    @Override
    protected BaseViewModel crateViewModel() {
        return ViewModelProviders.of(this).get(DashboardViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    protected List<Pair<String, String>> getNormalInfo() {
        return ((DashboardViewModel) viewModel).getHookInfo(getContext()
        );
    }
}