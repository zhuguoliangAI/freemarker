package com.example.freemarker.freemarker_demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JacksonExample {
    public static void main(String[] args) throws Exception {
        // 创建对象映射器
        ObjectMapper mapper = new ObjectMapper();

        // 创建一个Map对象并添加数据
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", "Jane Doe");
        jsonMap.put("age", 25);
        jsonMap.put("city", "Los Angeles");

        // 将Map对象转换为JSON字符串
        String jsonString = mapper.writeValueAsString(jsonMap);
        System.out.println(jsonString);

        // 解析JSON字符串
        jsonMap = mapper.readValue(jsonString, Map.class);
        String name = (String) jsonMap.get("name");
        System.out.println(name);
    }
}

