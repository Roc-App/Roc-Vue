package com.roc.test;import java.util.HashMap;import java.util.Map;/** * @version 1.0 * update_data:      update_author:      update_note: * @Copyright (C), 北京思特奇信息技术股份有限公司 * @Date 2023/2/9 11:19 * @Author: wkp * @Title: Test1 * @Description：TODO */public class Test1 {    public static void main(String[] args) {        Map<String, Object> map1 = new HashMap<>(1);        map1.put("1", 1);        map1.put("2", 1);        map1.put("3", 1);        System.out.println(map1.hashCode());        Map<String, Object> map2 = new HashMap<>();        map2.put("1", 1);        System.out.println(map2.hashCode());        Map<String, Object> map3 = new HashMap<>();        map3.put("3", 1);        System.out.println(map3.hashCode());        System.out.println("map1 == map2 ：");        System.out.println(map1.get("1") == map2.get("1"));        System.out.println("map1 == map1 ：");        System.out.println(map1.get("1") == map1.get("2"));        String str = "a";        System.out.println("str.hashCode()：" + str.hashCode());    }}