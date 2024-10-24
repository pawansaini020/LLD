package com.pawan.LLD;

import com.pawan.LLD.dto.Bug;
import com.pawan.LLD.dto.Feature;
import com.pawan.LLD.dto.Sprint;
import com.pawan.LLD.dto.Story;
import com.pawan.LLD.dto.SubTrack;
import com.pawan.LLD.dto.Task;
import com.pawan.LLD.enums.TaskImpact;
import com.pawan.LLD.enums.TaskSeverity;
import com.pawan.LLD.enums.TaskStatus;
import com.pawan.LLD.enums.TaskType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 24/10/24.
 */
public class TaskPlanner {
    private Map<String, Task> tasks;
    private Map<String, Sprint> sprints;

    public TaskPlanner() {
        this.tasks = new HashMap<>();
        this.sprints = new HashMap<>();
    }

    public Task createTask(String title, String creator, TaskType type, Date dueDate, String... additionalParams) {
        Task task = null;
        switch (type) {
            case FEATURE -> task = new Feature(title, creator, dueDate, additionalParams[0], TaskImpact.valueOf(additionalParams[1]));
            case BUG -> task = new Bug(title, creator, dueDate, TaskSeverity.valueOf(additionalParams[0]));
            case STORY -> task = new Story(title, creator, dueDate);
        }
        if(task!=null) {
            tasks.put(title, task);
        }
        return task;
    }

    public void createSubTrack(String storyTitle, String subTrackTitle) {
        Task task = tasks.get(storyTitle);
        if(task.getType() == TaskType.STORY) {
            Story story = (Story) task;
            SubTrack subTrack = new SubTrack(subTrackTitle);
            story.addSubTrack(subTrack);
        } else  {
            System.out.println("Subtracks can only be created for stories.");
        }
    }

    public void changeAssignee(String title, String assignee) {
        Task task = tasks.get(title);
        if(task!=null) {
            task.setAssignee(assignee);
        }
    }

    public void createSprint(String sprintId) {
        sprints.put(sprintId, new Sprint(sprintId));
    }

    public void addTaskToSprint(String sprintId, String taskTitle) {
        Sprint sprint = sprints.get(sprintId);
        Task task = tasks.get(taskTitle);
        if(sprint != null && task != null) {
            sprint.addTask(task);
        }
    }

    public void displayTasksForUser(String assignee) {
        System.out.println("Task for user: " + assignee);
        for (Task task : tasks.values()) {
            if(assignee.equals(task.getAssignee())) {
                System.out.println("Task type: " + task.getType() + " title: " + task.getTitle()  + " status: " + task.getStatus() + " sprint: "+ task.getSprint());
                if(task.getType() == TaskType.STORY) {
                    Story story = (Story) task;
                    for (SubTrack subTrack : story.getSubTracks()) {
                        System.out.println("SubTrack: " + subTrack.getTitle() + ", Status: " + subTrack.getStatus());
                    }
                }
            }
        }
    }

    public void displaySprintSnapshot(String sprintId) {
        Sprint sprint = sprints.get(sprintId);
        if (sprint != null) {
            sprint.displaySnapshot();
        }
    }
    public void addTaskStatus(TaskStatus taskStatus, String taskTitle) throws Exception {
        Task task = tasks.get(taskTitle);
        if(task != null) {
            task.changeStatus(taskStatus);
        }
    }
}
