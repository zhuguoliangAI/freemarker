package com.example.freemarker.freemarker_demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonExample {
    public static void main(String[] args) {
        // 创建JSONObject对象
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "John");
        jsonObj.put("age", 30);
        jsonObj.put("city", "New York");

        // 将JSONObject转换为JSON字符串
        String jsonString = jsonObj.toJSONString();
        System.out.println("JSON String: " + jsonString);

        // 将JSON字符串解析为JSONObject对象
        JSONObject jsonObj2 = JSON.parseObject(jsonString);
        System.out.println("Name: " + jsonObj2.getString("name"));
        System.out.println("Age: " + jsonObj2.getInteger("age"));

        // 将JSON字符串转换为Java对象
        Person person = JSON.parseObject(jsonString, Person.class);
        System.out.println("Person Name: " + person.getName());
    }

    public static class Person {
        private String name;
        private Integer age;

        // getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
