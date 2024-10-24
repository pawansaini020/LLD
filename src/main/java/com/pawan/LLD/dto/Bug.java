package com.pawan.LLD.dto;

import com.pawan.LLD.enums.TaskImpact;
import com.pawan.LLD.enums.TaskSeverity;
import com.pawan.LLD.enums.TaskStatus;
import com.pawan.LLD.enums.TaskType;
import lombok.Data;

import java.util.Date;
import java.util.EnumSet;

/**
 * @author Pawan Saini
 * Created on 24/10/24.
 */
@Data
public class Bug extends Task {
    private TaskSeverity severity;

    public Bug(String title, String creator, Date dueDate, TaskSeverity severity) {
        super(title, creator, TaskType.BUG, dueDate);
        this.severity = severity;
    }

    @Override
    protected boolean isValidTransition(TaskStatus newStatus) {
        return EnumSet.of(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.FIXED).contains(newStatus);
    }
}
