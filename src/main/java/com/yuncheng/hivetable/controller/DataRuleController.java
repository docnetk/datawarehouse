package com.yuncheng.hivetable.controller;

import com.yuncheng.hivetable.service.DataRuleService;
import com.yuncheng.hivetable.annotion.DataSource;
import com.yuncheng.hivetable.domain.rule.StandardDictDTO;
import com.yuncheng.hivetable.domain.rule.StandardTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataRuleController {
    @Autowired
    private DataRuleService dataRuleService;

    @GetMapping("/api/rule/dicts")
    @DataSource("second_datasource")
    public List<StandardDictDTO> getAllDicts() {
        return dataRuleService.getAllDicts();
    }

    @GetMapping("/api/rule/types")
    @DataSource("second_datasource")
    public List<StandardTypeDTO> getAllTypes() {
        return dataRuleService.getAllTypes();
    }
}
