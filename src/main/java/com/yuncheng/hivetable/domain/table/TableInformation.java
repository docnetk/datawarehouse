package com.yuncheng.hivetable.domain.table;

import java.util.List;
import java.util.Map;

public class TableInformation {
    private int count;
    private Map<String, List<ColumnInfo>> tableStructures;

    public TableInformation(int count, Map<String, List<ColumnInfo>> tableStructures) {
        this.count = count;
        this.tableStructures = tableStructures;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTableStructures(Map<String, List<ColumnInfo>> tableStructures) {
        this.tableStructures = tableStructures;
    }

    public int getCount() {
        return count;
    }

    public Map<String, List<ColumnInfo>> getTableStructures() {
        return tableStructures;
    }
}
