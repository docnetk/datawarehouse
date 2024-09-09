package com.yuncheng.hivetable.service;


import com.yuncheng.hivetable.domain.table.CreateTableDTO;
import com.yuncheng.hivetable.domain.table.TableInformation;

public interface HiveService {
    String createHiveTable(CreateTableDTO queryDTO);

    String previewTable(CreateTableDTO queryDTO);

    TableInformation getHiveTables();
}
