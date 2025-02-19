package com.pawan.LLD.lld.splitwise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SplitDetails {

    private User user;
    private Double amount;
    private Double percent;
    private String description;
}
