package com.yuncheng.hivetable.service.impl;

import com.yuncheng.hivetable.service.DataRuleService;
import com.yuncheng.hivetable.domain.rule.StandardDictDTO;
import com.yuncheng.hivetable.domain.rule.StandardTypeDTO;
import com.yuncheng.hivetable.mapper.db2.DataRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRuleServiceImpl implements DataRuleService {
    @Autowired
    private DataRuleMapper dataRuleMapper;

    @Override
    public List<StandardDictDTO> getAllDicts() {
        return dataRuleMapper.getAllDicts();
    }

    @Override
    public List<StandardTypeDTO> getAllTypes() {
        return dataRuleMapper.getAllTypes();
    }
}
