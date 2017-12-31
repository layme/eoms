package com.gwssi.eoms.util;

import java.util.*;

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
     *
     * @param param
     * @param regex
     * @return
     */
    public static List<String> stringToList(String param, String regex) {
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
     *
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

    //生成随机数字和字母
    public static String getStringRandom(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            if (random.nextInt(2) % 2 == 0) {
                //输出是大写字母
                sb.append((char) (random.nextInt(26) + 65));
            } else {
                sb.append(String.valueOf(random.nextInt(10)));
            }
        }
        return sb.toString();
    }
}
