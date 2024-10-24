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

    public Bug(String taskId, String title, String creator, Date dueDate, TaskSeverity severity) {
        super(taskId, title, creator, TaskType.BUG, dueDate);
        this.severity = severity;
    }

    @Override
    protected boolean isValidTransition(TaskStatus newStatus) {
        return EnumSet.of(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.FIXED).contains(newStatus);
    }

    @Override
    public void displayTask() {
        String track = this.dueDate.getTime() < new Date().getTime() ? "On Track" : "Delayed";
        System.out.println("Task id: " + this.getTaskId() +" Task type: " + this.getType() + " title: " + this.getTitle()  + " status: " + this.getStatus() + " sprint: "+ this.getSprint() + " track: " + track);    }
}
