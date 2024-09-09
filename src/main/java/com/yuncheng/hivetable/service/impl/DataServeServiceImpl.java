package com.yuncheng.hivetable.service.impl;

import com.yuncheng.hivetable.domain.VO.DataSetVO;
import com.yuncheng.hivetable.service.DataServeService;
import com.yuncheng.hivetable.domain.dataservice.DataSetDTO;
import com.yuncheng.hivetable.mapper.db1.DataSetMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServeServiceImpl implements DataServeService{
    @Autowired
    private DataSetMapper dataSetMapper;

    @Override
    public List<DataSetVO> queryAllDataSet() {
        List<DataSetDTO> dataSetDTOS = dataSetMapper.selectAllDataSet();
        List<DataSetVO> dataSetVOS = new ArrayList<>();
        // 转换为VO类
        for (DataSetDTO dataSetDTO : dataSetDTOS) {
            DataSetVO vo = new DataSetVO();
            BeanUtils.copyProperties(dataSetDTO, vo);
            dataSetVOS.add(vo);
        }
        return dataSetVOS;
    }
}
