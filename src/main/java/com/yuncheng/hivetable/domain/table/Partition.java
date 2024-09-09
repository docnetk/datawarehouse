package com.yuncheng.hivetable.domain.table;


public class Partition {
    private String name;  // 分区名
    private String type;  // 分区类型

    // Getter and Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
