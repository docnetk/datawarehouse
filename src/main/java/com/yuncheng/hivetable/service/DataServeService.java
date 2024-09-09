package com.yuncheng.hivetable.service;

import com.yuncheng.hivetable.domain.VO.DataSetVO;

import java.util.List;

public interface DataServeService {
    /**
     * 获取所有数据集
     * @return 所有数据集
     */
    List<DataSetVO> queryAllDataSet();
}
