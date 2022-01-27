package com.mmg.detection.info;

import android.content.Context;

import androidx.core.util.Pair;

import com.mmg.detection.utils.HookUtils;
import com.mmg.detection.utils.XposedHookUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chensongsong on 2020/7/16.
 */
public class HookInfo {

    public static List<Pair<String, String>> getHookInfo(Context context) {
        List<Pair<String, String>> list = new ArrayList<>();
        list.add(new Pair<>("Process", HookUtils.checkRunningProcesses(context) + ""));
        list.add(new Pair<>("XposedHookMethod", HookUtils.chargeXposedHookMethod()));
        list.add(new Pair<>("XposedJars", HookUtils.chargeXposedJars()));
        list.add(new Pair<>("XposedPackage", HookUtils.chargeXposedPackage(context)));
        list.add(new Pair<>("XposedInject", XposedHookUtils.checkXposedInjet(context).toString()));
        list.add(new Pair<>("XposedClass", HookUtils.classCheck() + ""));
        list.add(new Pair<>("安装riru?(需要root权限)", HookUtils.riruCheck(context) + ""));
        list.add(new Pair<>("root是否授权", HookUtils.rooterify(context) + ""));
        return list;
    }

}
