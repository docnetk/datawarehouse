package com.yuncheng.hivetable.mapper.db1;

import com.yuncheng.hivetable.domain.dataservice.DataSetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataSetMapper {

    @Select("select * from gaea_report_data_set where enable_flag = 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            @Result(property = "rowIndex", column = "row_index"),
            @Result(property = "setCode", column = "set_code"),
            @Result(property = "setName", column = "set_name"),
            @Result(property = "setDesc", column = "set_desc"),
            @Result(property = "setType", column = "set_type"),
            @Result(property = "sourceCode", column = "source_code"),
            @Result(property = "dynSentence", column = "dyn_sentence"),
            @Result(property = "caseResult", column = "case_result"),
            @Result(property = "enableFlag", column = "enable_flag"),
            @Result(property = "deleteFlag", column = "delete_flag")
    })
    List<DataSetDTO> selectAllDataSet();
}
