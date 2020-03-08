package com.study.spring.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author lianghong.tlh
 * @date 2020/03/04
 */
public class TestObject {

    private  int age;

    private String name;


    private List<String> subjects;


    private Map<String, String> relationMap;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Map<String, String> getRelationMap() {
        return relationMap;
    }

    public void setRelationMap(Map<String, String> relationMap) {
        this.relationMap = relationMap;
    }

    public void addSubject(String subject) {
         this.subjects = Optional.ofNullable(this.subjects).orElse(new ArrayList<>());
         this.subjects.add(subject);
    }


    public void addRelationMap(String key, String value) {
        this.relationMap = Optional.ofNullable(this.relationMap).orElse(new HashMap<>());
        this.relationMap.put(key, value);
    }

    @Override
    public String toString() {
        return "TestObject{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", subjects=" + subjects +
            ", relationMap=" + relationMap +
            '}';
    }

    public static void main(String[] args) {
        TestObject testObject = CommonBuilder.of(TestObject::new)
            .with(TestObject::setAge, 10)
            .with(TestObject::setName,"ZhangSan")
            .with(TestObject::addSubject, "English")
            .with(TestObject::addRelationMap,"father", "Job")
            .build();

        System.out.println(testObject);
    }
}
