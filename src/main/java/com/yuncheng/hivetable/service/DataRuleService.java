package com.yuncheng.hivetable.service;

import com.yuncheng.hivetable.domain.rule.StandardDictDTO;
import com.yuncheng.hivetable.domain.rule.StandardTypeDTO;

import java.util.List;

public interface DataRuleService {
    List<StandardDictDTO> getAllDicts();

    List<StandardTypeDTO> getAllTypes();
}
