package com.yuncheng.hivetable.domain.rule;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class StandardTypeDTO {
    /**
     * 主键
     */
    private String id;

    /**
     * 状态（0不启用，1启用）
     */
    private String status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 创建人所属部门
     */
    private String createDept;


    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;


    /**
     * 标准类别编码
     */
    private String gbTypeCode;

    /**
     * 标准类别名称
     */
    private String gbTypeName;


    public StandardTypeDTO() {}

    public StandardTypeDTO(String id, String status, String createBy, LocalDateTime createTime, String createDept, LocalDateTime updateTime, String updateBy, String remark, String gbTypeCode, String gbTypeName, String gbCode) {
        this.id = id;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.createDept = createDept;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.remark = remark;
        this.gbTypeCode = gbTypeCode;
        this.gbTypeName = gbTypeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGbTypeCode() {
        return gbTypeCode;
    }

    public void setGbTypeCode(String gbTypeCode) {
        this.gbTypeCode = gbTypeCode;
    }

    public String getGbTypeName() {
        return gbTypeName;
    }

    public void setGbTypeName(String gbTypeName) {
        this.gbTypeName = gbTypeName;
    }

}
