package com.mmg.detection.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.mmg.detection.model.beans.ApplicationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chensongsong on 2020/6/3.
 */
public class AppListInfo {

    /**
     * 获取应用列表
     *
     * @param context
     * @return
     */
    public static List<ApplicationBean> getAppListInfo(Context context) {
        List<ApplicationBean> list = new ArrayList<>();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(PackageManager.GET_META_DATA);
        for (PackageInfo info : installedPackages) {

            ApplicationBean bean = new ApplicationBean();
            ApplicationInfo app = info.applicationInfo;
//            if (!app.enabled)
//                continue;
           
            if (app.metaData != null && app.metaData.containsKey("xposedmodule")) {
                bean.setName(info.applicationInfo.loadLabel(packageManager).toString());
                bean.setPackageName(info.packageName);
                bean.setVersion(info.versionName);
                bean.setIcon(info.applicationInfo.loadIcon(packageManager));
                bean.setBuildVersion(info.applicationInfo.targetSdkVersion);
                if ((ApplicationInfo.FLAG_SYSTEM & info.applicationInfo.flags) == 0) {
                    bean.setSystemApp(false);
                } else {
                    bean.setSystemApp(true);
                }
                list.add(bean);
            }
        }
        return list;
    }

}
