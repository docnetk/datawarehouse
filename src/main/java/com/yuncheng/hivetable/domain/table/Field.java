package com.yuncheng.hivetable.domain.table;


public class Field {
    private String name;
    private String type;
    private String description;
    private String precision;

    public Field() {}

    public Field(String name, String type, String description, String precision) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.precision = precision;
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", precision='" + precision + '\'' +
                '}';
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
