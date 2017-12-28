package com.gwssi.eoms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2017/11/20
 * Time: 11:19
 * Description:
 */
public class LocalUtils {
    /**
     * String转List
     * @param param
     * @param regex
     * @return
     */
    public static List<String> stringToList (String param, String regex) {
        List<String> list = new ArrayList<>(4);
        if (param.contains(" ")) {
            String[] arr = param.split(regex);
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
        } else {
            list.add(param);
        }
        return list;
    }

    /**
     * 字符串去重
     * @param sortNum
     * @return
     */
    public static String stringDistinct(String sortNum) {
        if (null == sortNum || "".equals(sortNum)) {
            return sortNum;
        } else {
            sortNum.replace("，", ",");  // 防止有人手工补入的全角逗号
            String[] sortNumArr = sortNum.split(",");
            if (sortNumArr.length == 1) {
                return sortNum;
            } else {
                Set<String> set = new TreeSet<String>();
                for (int i = 0; i < sortNumArr.length; i++) {
                    set.add(sortNumArr[i]);  // 利用set不允许有重复元素和不空元素特性去重
                }
                // 去掉首尾的中括号和字符串中的空格
                return set.toString().replaceAll("\\[|\\]", "");
            }
        }
    }
}
