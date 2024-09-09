package com.yuncheng.hivetable.service.impl;

import com.yuncheng.hivetable.service.HiveService;
import com.yuncheng.hivetable.domain.table.CreateTableDTO;
import com.yuncheng.hivetable.domain.table.ColumnInfo;
import com.yuncheng.hivetable.domain.table.Field;
import com.yuncheng.hivetable.domain.table.Partition;
import com.yuncheng.hivetable.domain.table.TableInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HiveServiceImpl implements HiveService {

    @Value("${hive.url}")
    private String HIVE_JDBC_URL;

    @Value("${hive.user}")
    private String HIVE_USER;

    @Value("${hive.password}")
    private String HIVE_PASSWORD;

    @Override
    public String createHiveTable(CreateTableDTO queryDTO) {
        try {
            // 连接到 Hive
            Connection connection = DriverManager.getConnection(HIVE_JDBC_URL, HIVE_USER, HIVE_PASSWORD);

            // 查询表是否已存在
            PreparedStatement preparedStatement = connection.prepareStatement("SHOW TABLES LIKE ?");
            preparedStatement.setString(1, queryDTO.getTableName());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // 表已存在
                preparedStatement.close();
                connection.close();
                return "表名已存在";
            }

            // 构建 CREATE TABLE 语句
            StringBuilder createTableSql;
            if ("EXTERNAL".equals(queryDTO.getTableType())) {
                createTableSql = new StringBuilder("CREATE " + queryDTO.getTableType() + " TABLE IF NOT EXISTS " + "`" + queryDTO.getTableName() + "`" + " (\n");
            } else {
                createTableSql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + "`" + queryDTO.getTableName() + "`" + " (\n");
            }
            List<Field> fields = queryDTO.getFields();
            for (int i = 0; i < fields.size(); i++) {
                Field field = fields.get(i);
                if ("DECIMAL".equals(field.getType())) {
                    field.setType(field.getType() + "(" + field.getPrecision() + ")");
                }
                createTableSql.append("  ").append("`").append(field.getName()).append("`").append(" ").append(field.getType())
                        .append(" COMMENT ").append("\"").append(field.getDescription()).append("\"");
                if (i < fields.size() - 1) {
                    createTableSql.append(",\n");
                }
            }
            createTableSql.append("\n)");

            List<Partition> partitions = queryDTO.getPartitions();
            if (partitions != null && !partitions.isEmpty()) {
                createTableSql.append("\nPARTITIONED BY (");
                for (int i = 0; i < partitions.size(); i++) {
                    Partition partition = partitions.get(i);
                    createTableSql.append("`").append(partition.getName()).append("`").append(" ").append(partition.getType());
                    if (i < partitions.size() - 1) {
                        createTableSql.append(",");
                    }
                }
                createTableSql.append(")");
            }
            createTableSql.append("\n");

            if ("orc".equals(queryDTO.getCompressionType())) {
                createTableSql.append("STORED AS ORC");
            } else if ("torc".equals(queryDTO.getCompressionType())) {
                createTableSql.append("STORED AS ORC\n" +
                        "TBLPROPERTIES('transactional'='true')");
            } else if ("holodesk".equals(queryDTO.getCompressionType())) {
                createTableSql.append("STORED AS HOLODESK");
            } else if ("text".equals(queryDTO.getCompressionType())) {
                if ("EXTERNAL".equals(queryDTO.getTableType()) && !"".equals(queryDTO.getSeparator())) {
                    createTableSql.append("ROW FORMAT DELIMITED FIELDS TERMINATED BY ").append(queryDTO.getSeparator()).append("\n").append("STORED AS TEXTFILE");
                } else {
                    createTableSql.append("STORED AS TEXTFILE");
                }
            }
            createTableSql.append("\n");
            if ("EXTERNAL".equals(queryDTO.getTableType()) && !"".equals(queryDTO.getLocation())) {
                createTableSql.append("LOCATION " + "'").append(queryDTO.getLocation()).append("'");
            }
//            System.out.println(createTableSql);
            // 执行 SQL 语句
            Statement statement = connection.createStatement();
            statement.execute(createTableSql.toString());

            // 关闭资源
            statement.close();
            connection.close();

            // 返回成功响应
            return "建表成功";
        } catch (Exception e) {
            e.printStackTrace();
            // 返回错误响应
            return "建表失败，请重试";
        }
    }

    @Override
    public String previewTable(CreateTableDTO queryDTO) {
        // 构建 CREATE TABLE 语句
        StringBuilder createTableSql;
        if ("EXTERNAL".equals(queryDTO.getTableType())) {
            createTableSql = new StringBuilder("CREATE " + queryDTO.getTableType() + " TABLE IF NOT EXISTS " + "`" + queryDTO.getTableName() + "`" + " (\n");
        } else {
            createTableSql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + "`" + queryDTO.getTableName() + "`" + " (\n");
        }
        List<Field> fields = queryDTO.getFields();
        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            if ("DECIMAL".equals(field.getType())) {
                field.setType(field.getType() + "(" + field.getPrecision() + ")");
            }
            createTableSql.append("  ").append("`").append(field.getName()).append("`").append(" ").append(field.getType())
                    .append(" COMMENT ").append("\"").append(field.getDescription()).append("\"");
            if (i < fields.size() - 1) {
                createTableSql.append(",\n");
            }
        }
        createTableSql.append("\n)");

        List<Partition> partitions = queryDTO.getPartitions();
        if (partitions != null && !partitions.isEmpty()) {
            createTableSql.append("\nPARTITIONED BY (");
            for (int i = 0; i < partitions.size(); i++) {
                Partition partition = partitions.get(i);
                createTableSql.append("`").append(partition.getName()).append("`").append(" ").append(partition.getType());
                if (i < partitions.size() - 1) {
                    createTableSql.append(",");
                }
            }
            createTableSql.append(")");
        }
        createTableSql.append("\n");

        if ("orc".equals(queryDTO.getCompressionType())) {
            createTableSql.append("STORED AS ORC");
        } else if ("torc".equals(queryDTO.getCompressionType())) {
            createTableSql.append("STORED AS ORC\n" +
                    "TBLPROPERTIES('transactional'='true')");
        } else if ("holodesk".equals(queryDTO.getCompressionType())) {
            createTableSql.append("STORED AS HOLODESK");
        } else if ("text".equals(queryDTO.getCompressionType())) {
            if ("EXTERNAL".equals(queryDTO.getTableType()) && !"".equals(queryDTO.getSeparator())) {
                createTableSql.append("ROW FORMAT DELIMITED FIELDS TERMINATED BY ").append(queryDTO.getSeparator()).append("\n").append("STORED AS TEXTFILE");
            } else {
                createTableSql.append("STORED AS TEXTFILE");
            }
        }
        createTableSql.append("\n");
        if ("EXTERNAL".equals(queryDTO.getTableType()) && !"".equals(queryDTO.getLocation())) {
            createTableSql.append("LOCATION " + "'").append(queryDTO.getLocation()).append("'");
        }
//        System.out.println(createTableSql);
        return createTableSql.toString();
    }

    @Override
    public TableInformation getHiveTables() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Map<String, List<ColumnInfo>> tableStructures = new HashMap<>();

        try {
            // Step 1: Establish connection
            connection = DriverManager.getConnection(HIVE_JDBC_URL, HIVE_USER, HIVE_PASSWORD);
            statement = connection.createStatement();

            // Step 2: Get all table names
            resultSet = statement.executeQuery("SHOW TABLES");
            List<String> tables = new ArrayList<>();
            while (resultSet.next()) {
                tables.add(resultSet.getString(1));
            }

            // Step 3: For each table, get its structure
            for (String table : tables) {
                ResultSet describeResultSet = statement.executeQuery("DESCRIBE `" + table + "`");

                List<ColumnInfo> columns = new ArrayList<>();
                while (describeResultSet.next()) {
                    String columnName = describeResultSet.getString(1);
                    String columnType = describeResultSet.getString(2);
                    columns.add(new ColumnInfo(columnName, columnType));
                }
                tableStructures.put(table, columns);
                describeResultSet.close();
            }

            return new TableInformation(tables.size(), tableStructures);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // Step 4: Close all resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
