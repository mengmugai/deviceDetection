package com.mmg.detection.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.core.util.Pair;

import com.google.firebase.perf.metrics.AddTrace;
import com.mmg.detection.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chensongsong on 2020/9/22.
 */
public class TestInfo {

    @AddTrace(name = "TestInfo.getTestInfo")
    public static List<Pair<String, String>> getTestInfo(Context context) {
        boolean enable = false;
        List<Pair<String, String>> list = new ArrayList<>();
//        WifiManager manager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        PackageManager packageManager = context.getApplicationContext().getPackageManager();
//        packageManager.getPackageInfo(schedulerTask.moduleApkPackage, PackageManager.GET_META_DATA);
//        List<PackageInfo> packageInfos = context.getPackageManager().getInstalledPackages(PackageManager.GET_ACTIVITIES |
//                PackageManager.GET_SERVICES);

        List<PackageInfo> packageInfos = context.getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);
        if (packageInfos != null && !packageInfos.isEmpty()) {
            for (PackageInfo info  : packageInfos) {
                ApplicationInfo app = info.applicationInfo;
                if (!app.enabled)
                    continue;
                if (app.metaData != null && app.metaData.containsKey("xposedmodule")){
                    list.add(new Pair<>("packageName", info.packageName));
                    list.add(new Pair<>("sharedUserId", info.sharedUserId));
                    list.add(new Pair<>("versionName", info.versionName));
                    list.add(new Pair<>("meta", info.applicationInfo.metaData.toString()));
                    list.add(new Pair<>("", ""));
                }


            }
        }



        if (list.isEmpty()) {
            if (enable) {
                list.add(new Pair<>("WIFI Scan", context.getString(R.string.usb_not_found)));
            } else {
                list.add(new Pair<>("WIFI Scan", "Please turn on WiFi switch"));
            }
        }
        return list;
    }

}
