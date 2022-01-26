package com.mmg.detection.info;

import android.content.Context;

import androidx.core.util.Pair;

import com.mmg.detection.utils.BatteryUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chensongsong on 2020/6/1.
 */
public class BatteryInfo {

    /**
     * 获取电池信息
     *
     * @return 电池JSON
     */
    public static List<Pair<String, String>> getBatteryInfo(Context context) {
        ArrayList<Pair<String, String>> list = new ArrayList<>();
        BatteryUtils.getBatteryInfo(context, list);
        return list;
    }

}
