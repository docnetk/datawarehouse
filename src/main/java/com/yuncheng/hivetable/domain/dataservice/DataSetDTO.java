package com.yuncheng.hivetable.domain.dataservice;

import java.util.Date;

public class DataSetDTO {

    private Long id;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer version;

    private String setCode;

    private String setName;

    private String setDesc;

    private String setType;

    private String sourceCode;

    private String dynSentence;

    private String caseResult;

    private Integer enableFlag;

    private Integer deleteFlag;

    public DataSetDTO() {
    }

    public DataSetDTO(Long id, String createBy, Date createTime, String updateBy, Date updateTime, Integer version, Integer rowIndex, String setCode, String setName, String setDesc, String setType, String sourceCode, String dynSentence, Integer enableFlag, String caseResult, Integer deleteFlag) {
        this.id = id;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.version = version;
        this.setCode = setCode;
        this.setName = setName;
        this.setDesc = setDesc;
        this.setType = setType;
        this.sourceCode = sourceCode;
        this.dynSentence = dynSentence;
        this.enableFlag = enableFlag;
        this.caseResult = caseResult;
        this.deleteFlag = deleteFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetDesc() {
        return setDesc;
    }

    public void setSetDesc(String setDesc) {
        this.setDesc = setDesc;
    }

    public String getSetType() {
        return setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getDynSentence() {
        return dynSentence;
    }

    public void setDynSentence(String dynSentence) {
        this.dynSentence = dynSentence;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
