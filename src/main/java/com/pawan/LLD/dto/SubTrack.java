package com.pawan.LLD.dto;

import com.pawan.LLD.dto.Task;
import com.pawan.LLD.enums.TaskSeverity;
import com.pawan.LLD.enums.TaskStatus;
import com.pawan.LLD.enums.TaskType;
import lombok.Data;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 24/10/24.
 */
@Data
public class SubTrack {

    protected String title;
    protected TaskStatus status;

    public SubTrack(String title) {
        this.title = title;
        this.status = TaskStatus.OPEN;
    }
}
