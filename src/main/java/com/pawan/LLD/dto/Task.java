package com.pawan.LLD.dto;

import com.pawan.LLD.enums.TaskStatus;
import com.pawan.LLD.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 24/10/24.
 */
@Data
public class Task {

    protected String title;
    protected String creator;
    protected String assignee;
    protected TaskStatus status;
    protected TaskType type;
    protected Date dueDate;
    protected String sprint;

    public Task(String title, String assignee, TaskType type, Date dueDate) {
        this.title = title;
        this.assignee = assignee;
        this.type = type;
        this.dueDate = dueDate;
        this.status = TaskStatus.OPEN;
    }

    public void changeStatus(TaskStatus newStatus) throws Exception {
        if(isValidTransition(newStatus)) {
            this.status = newStatus;
        } else {
            throw new Exception("Invalide status transition for: " + type + " task.");
        }
    }

    protected boolean isValidTransition(TaskStatus newStatus) {
        return true; // Allow all transitions for now
    }
}
