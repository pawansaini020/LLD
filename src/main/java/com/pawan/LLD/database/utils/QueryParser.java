package com.pawan.LLD.database.utils;

import com.pawan.LLD.database.dto.ColumnDTO;
import com.pawan.LLD.database.dto.SchemaDTO;
import com.pawan.LLD.database.dto.TableDTO;
import com.pawan.LLD.database.dto.TableData;
import com.pawan.LLD.database.enums.ColumnType;
import com.pawan.LLD.database.enums.Constrains;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
public class QueryParser {

    public static TableDTO parseCreateTableQuery(String query) {
        String strings[] = query.split("\\(");
        if(strings.length<2) {
            throw new RuntimeException("Query is not valid");
        }
        String tableName = strings[0].split(" ")[2];
        String columnsData[] = strings[1].split("\\)")[0].split(",");
        List<ColumnDTO> columns = new ArrayList<>();
        for(String columnData : columnsData) {
            String columnInfo[] = columnData.split(" ");
            ColumnDTO column = new ColumnDTO(columnInfo[0], ColumnType.valueOf(columnInfo[1]), Constrains.valueOf(columnInfo[2]), columnInfo[3]);
            columns.add(column);
        }
        return new TableDTO(tableName, new SchemaDTO(columns), new TableData());
    }
}
