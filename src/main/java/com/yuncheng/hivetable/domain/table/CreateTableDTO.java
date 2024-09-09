package com.yuncheng.hivetable.domain.table;

import java.util.List;

public class CreateTableDTO {

    private String tableName;  // 表名
    private String tableType;  // 表类型，INTERNAL 或 EXTERNAL
    private String location;   // 表的位置 (仅当表类型为 EXTERNAL 时使用)
    private String compressionType; // 压缩类型
    private String separator;
    private List<Field> fields; // 字段列表
    private List<Partition> partitions; // 分区列表

    public CreateTableDTO(String tableName, String tableType, String location, String compressionType, String separator, List<Field> fields, List<Partition> partitions) {
        this.tableName = tableName;
        this.tableType = tableType;
        this.location = location;
        this.compressionType = compressionType;
        this.separator = separator;
        this.fields = fields;
        this.partitions = partitions;
    }

    @Override
    public String toString() {
        return "CreateTableDTO{" +
                "tableName='" + tableName + '\'' +
                ", tableType='" + tableType + '\'' +
                ", location='" + location + '\'' +
                ", compressionType='" + compressionType + '\'' +
                ", separator='" + separator + '\'' +
                ", fields=" + fields +
                ", partitions=" + partitions +
                '}';
    }

    public CreateTableDTO() {}

    public String getTableName() {
        return tableName;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompressionType() {
        return compressionType;
    }

    public void setCompressionType(String compressionType) {
        this.compressionType = compressionType;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<Partition> partitions) {
        this.partitions = partitions;
    }
}

