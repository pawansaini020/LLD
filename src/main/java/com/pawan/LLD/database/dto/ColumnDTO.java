package com.pawan.LLD.database.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.database.enums.ColumnType;
import com.pawan.LLD.database.enums.Constrains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnDTO {

    private String name;
    private ColumnType type;
    private Constrains constrain;
    private Object constrainValue;
}
