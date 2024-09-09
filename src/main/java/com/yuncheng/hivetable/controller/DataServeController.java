package com.yuncheng.hivetable.controller;

import com.yuncheng.hivetable.annotion.DataSource;
import com.yuncheng.hivetable.domain.VO.DataSetVO;
import com.yuncheng.hivetable.service.DataServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataServeController {
    @Autowired
    private DataServeService dataServeService;

    /**
     * 获取所有数据
     */
    @GetMapping("/api/dataset/queryAllDataSet")
    @DataSource
    public List<DataSetVO> queryAllDataSet() {
        return dataServeService.queryAllDataSet();
    }
}
