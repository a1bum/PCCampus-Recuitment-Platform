package top.a1bum.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

import com.alibaba.fastjson.util.IdentityHashMap;
import com.google.common.collect.Maps;

public class MapUtil extends cn.hutool.core.map.MapUtil {
    public static HashMap newHashMap(Object... keyValues) {
        return newMap(HashMap.class, keyValues);
    }

    private static <R extends Map> R newMap(Class<? extends Map> type, Object... keyValues) {

        int length = keyValues.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("参数不符合预期, 可变数组应该成对出现。");
        }
        Map resultMap;
        if (type == HashMap.class) {
            resultMap = Maps.newHashMap();
        } else if (type == ConcurrentMap.class) {
            resultMap = Maps.newConcurrentMap();
        } else if (type == TreeMap.class) {
            resultMap = Maps.newTreeMap();
        } else if (type == LinkedHashMap.class) {
            resultMap = Maps.newLinkedHashMap();
        } else if (type == IdentityHashMap.class) {
            resultMap = Maps.newIdentityHashMap();
        } else {
            throw new IllegalArgumentException("MapUtil#newMap() type = " + type.getSimpleName() + " 不支持。");
        }
        for (int i = 0; i < length; i = i + 2) {
            resultMap.put(keyValues[i], keyValues[i + 1]);
        }
        return (R) resultMap;
    }
}
