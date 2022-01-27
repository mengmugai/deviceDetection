package com.mmg.detection.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.mmg.detection.R;
import com.mmg.detection.databinding.FragmentNotificationsBinding;
import com.mmg.detection.model.beans.ApplicationBean;
import com.mmg.detection.ui.base.BaseAdapter;
import com.mmg.detection.ui.base.BaseFragment;
import com.mmg.detection.ui.base.BaseViewModel;
import com.mmg.detection.utils.LogUtils;
import com.mmg.detection.utils.ThreadPoolUtils;

import org.json.JSONArray;

import java.util.List;

public class NotificationsFragment extends BaseFragment<ApplicationBean> {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        notificationsViewModel =
//                new ViewModelProvider(this).get(NotificationsViewModel.class);
//
//        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
//    }

    @Override
    protected BaseAdapter crateAdapter() {
        return new AppListAdapter(getContext());
    }

    @Override
    protected BaseViewModel crateViewModel() {
        return ViewModelProviders.of(this).get(NotificationsViewModel.class);
    }

    @Override
    protected void refreshData() {
        ThreadPoolUtils.getInstance().execute(() -> {
            final List<ApplicationBean> list = getAppListInfo();
            JSONArray jsonArray = new JSONArray();
            for (ApplicationBean bean : list) {
                try {
                    jsonArray.put(bean.toJSON());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LogUtils.printLongString(jsonArray.toString());
            mainHandler.post(() -> {
                viewModel.setValue(list);
            });
        });
    }

    private List<ApplicationBean> getAppListInfo() {
        return ((NotificationsViewModel) viewModel).getAppListInfo(getContext());
    }

}