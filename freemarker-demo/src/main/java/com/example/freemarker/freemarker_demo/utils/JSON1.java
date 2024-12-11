package com.example.freemarker.freemarker_demo.utils;

import org.json.JSONObject;

public class JSON1 {
        public static void main(String[] args) {
            // 创建JSON对象
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", "John Doe");
            jsonObj.put("age", 30);
            jsonObj.put("city", "New York");

            // 将JSON对象转换为字符串
            String jsonString = jsonObj.toString();
            System.out.println(jsonString);

            // 解析JSON字符串
            JSONObject jsonObjParsed = new JSONObject(jsonString);
            String name = jsonObjParsed.getString("name");
            System.out.println(name);
        }

}
