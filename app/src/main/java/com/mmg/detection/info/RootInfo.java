package com.mmg.detection.info;

import android.content.Context;

import androidx.core.util.Pair;

import com.mmg.detection.utils.CommandUtils;
import com.mmg.detection.utils.RootUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chensongsong on 2020/7/15.
 */
public class RootInfo {

    public static List<Pair<String, String>> getRootInfo(Context context) {
        List<Pair<String, String>> list = new ArrayList<>();
        list.add(new Pair<>("Su_v", CommandUtils.execute("su -v")));
        list.add(new Pair<>("RwPaths", RootUtils.existingRWPaths().toString()));
        list.add(new Pair<>("DangerousProperties", RootUtils.existingDangerousProperties().toString()));
        list.add(new Pair<>("RootFiles", RootUtils.existingRootFiles().toString()));
        list.add(new Pair<>("RootPackages", RootUtils.existingRootPackages(context).toString()));
        return list;
    }

}
