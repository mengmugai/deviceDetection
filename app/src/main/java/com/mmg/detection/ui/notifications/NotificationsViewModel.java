package com.mmg.detection.ui.notifications;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mmg.detection.info.AppListInfo;
import com.mmg.detection.model.beans.ApplicationBean;
import com.mmg.detection.ui.base.BaseViewModel;

import java.util.List;

public class NotificationsViewModel extends BaseViewModel {

    protected List<ApplicationBean> getAppListInfo(Context context) {
        return AppListInfo.getAppListInfo(context);
    }
}