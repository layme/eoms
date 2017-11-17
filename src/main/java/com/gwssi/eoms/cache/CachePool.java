package com.gwssi.eoms.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/10
 * Time: 14:20
 * Description:
 */
public class CachePool {
    private static Map cachePool = new HashMap();

    public static void setValue(Object key, Object value) {
        cachePool.put(key, value);
    }

    public static Object getValue(Object key) {
        return cachePool.get(key);
    }
}
