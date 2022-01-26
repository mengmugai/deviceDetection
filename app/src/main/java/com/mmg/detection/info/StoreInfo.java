package com.mmg.detection.info;

import android.content.Context;

import com.mmg.detection.model.beans.StorageBean;
import com.mmg.detection.utils.MemoryUtils;
import com.mmg.detection.utils.SdUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chensongsong on 2020/6/1.
 */
public class StoreInfo {

    /**
     * 获取内存信息
     *
     * @param context
     * @return
     */
    public static List<StorageBean> getStoreInfo(Context context) {
        List<StorageBean> list = new ArrayList<>();
        StorageBean bean = new StorageBean();
        SdUtils.getStoreInfo(context, bean);
        MemoryUtils.getMemoryInfo(context, bean);
        list.add(bean);
        return list;
    }

}
