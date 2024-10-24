package com.pawan.LLD.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 24/10/24.
 */

public class Sprint {
    private String sprintId;
    private List<Task> tasks;

    public Sprint(String sprintId) {
        this.sprintId = sprintId;
        tasks = new ArrayList<>();
    }


    public void addTask(Task task) {
        if(task.getSprint() == null) {
            task.setSprint(this.sprintId);
            tasks.add(task);
        }
    }

    public void removeTask(Task task) {
        if(tasks.contains(task)) {
            tasks.remove(task);
            task.setSprint(null);
        }
    }

    public void displaySnapshot() {
        for(Task task : tasks) {
            String track = task.dueDate.getTime() < new Date().getTime() ? "On Track" : "Delayed";
            System.out.println("Task title: " + task.getTitle() + " status: " + task.getStatus() + " sprint: "+ this.sprintId + "track: "+ track);
        }
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }
}
