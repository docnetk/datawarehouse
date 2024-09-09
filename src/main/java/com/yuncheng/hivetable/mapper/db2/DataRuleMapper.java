package com.yuncheng.hivetable.mapper.db2;

import com.yuncheng.hivetable.domain.rule.StandardDictDTO;
import com.yuncheng.hivetable.domain.rule.StandardTypeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataRuleMapper {

    @Select("select * from standard_dict where status=1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createDept", column = "create_dept"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "createDept", column = "create_dept"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "gbCode", column = "gb_code"),
            @Result(property = "gbName", column = "gb_name")
    })
    List<StandardDictDTO> getAllDicts();

    @Select("select * from standard_type where status=1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createDept", column = "create_dept"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "gbTypeCode", column = "gb_type_code"),
            @Result(property = "gbTypeName", column = "gb_type_name"),
    })
    List<StandardTypeDTO> getAllTypes();
}
