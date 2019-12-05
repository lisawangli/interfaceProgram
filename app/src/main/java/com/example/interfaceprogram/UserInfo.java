package com.example.interfaceprogram;

public class UserInfo {
    private String name;
    private int age;
    private int type;
    private String account;

    public UserInfo(String name, int age, int type, String account) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.account = account;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", account='" + account + '\'' +
                '}';
    }
}
