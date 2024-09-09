package com.yuncheng.hivetable.controller;


import com.yuncheng.hivetable.service.HiveService;
import com.yuncheng.hivetable.domain.table.CreateTableDTO;
import com.yuncheng.hivetable.domain.table.TableInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiveController {

    @Autowired
    private HiveService hiveService;

    @PostMapping("/api/hive/create-table")
    public String createHiveTable(@RequestBody CreateTableDTO queryDTO) {
        return hiveService.createHiveTable(queryDTO);
    }

    @PostMapping("/api/hive/pre-table")
    public String previewTable(@RequestBody CreateTableDTO queryDTO) {
        return hiveService.previewTable(queryDTO);
    }

    @GetMapping("/api/hive/tables")
    public TableInformation getHiveTables() {
        return hiveService.getHiveTables();
    }
}
