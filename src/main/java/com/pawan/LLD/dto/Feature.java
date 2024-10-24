package com.pawan.LLD.dto;

import com.pawan.LLD.enums.TaskImpact;
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
public class Feature extends Task {

    private String summary;
    private TaskImpact impact;

    public Feature(String title, String creator, Date dueDate, String summary, TaskImpact impact) {
        super(title, creator, TaskType.FEATURE, dueDate);
        this.summary = summary;
        this.impact = impact;
    }

    @Override
    protected boolean isValidTransition(TaskStatus newStatus) {
        return EnumSet.of(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.TESTING, TaskStatus.DEPLOYED)
                .contains(newStatus);
    }
}
