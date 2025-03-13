package com.pawan.LLD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Column {

    private String name;
    private DataType dataType;
    private Boolean isPrimary;
    private Boolean isUnique;
}
