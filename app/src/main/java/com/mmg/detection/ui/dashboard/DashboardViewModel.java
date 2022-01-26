package com.mmg.detection.ui.dashboard;

import android.content.Context;

import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mmg.detection.info.DeviceInfo;
import com.mmg.detection.info.HookInfo;
import com.mmg.detection.info.OthersInfo;
import com.mmg.detection.info.RootInfo;
import com.mmg.detection.ui.base.NormalViewModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewModel extends NormalViewModel {

    public List<Pair<String, String>> getHookInfo(Context context) {
        List<Pair<String, String>> list = new ArrayList<>();
//        list.addAll(HookInfo.getHookInfo(context));
//        list.addAll(RootInfo.getRootInfo(context));
        list.addAll(DeviceInfo.getDeviceInfo(context));
        list.addAll(OthersInfo.getOthersInfo(context));
        return list;
    }
}