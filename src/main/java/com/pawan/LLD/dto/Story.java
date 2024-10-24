package com.pawan.LLD.dto;

import com.pawan.LLD.dto.SubTrack;
import com.pawan.LLD.dto.Task;
import com.pawan.LLD.enums.TaskSeverity;
import com.pawan.LLD.enums.TaskStatus;
import com.pawan.LLD.enums.TaskType;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 24/10/24.
 */
@Data
public class Story extends Task {

    private String summary;
    private List<SubTrack> subTracks;

    public Story(String taskId, String title, String creator, Date dueDate) {
        super(taskId, title, creator, TaskType.STORY, dueDate);
        this.summary = summary;
        subTracks = new ArrayList<>();
    }

    public void addSubTrack(SubTrack subTrack) {
        if(this.status != TaskStatus.COMPLETED) {
            subTracks.add(subTrack);
        }
    }

    @Override
    protected boolean isValidTransition(TaskStatus newStatus) {
        return EnumSet.of(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.COMPLETED).contains(newStatus);
    }

    @Override
    public void displayTask() {
        String track = this.dueDate.getTime() < new Date().getTime() ? "On Track" : "Delayed";
        System.out.println("Task id: " + this.getTaskId() +" Task type: " + this.getType() + " title: " + this.getTitle()  + " status: " + this.getStatus() + " sprint: "+ this.getSprint() + " track: " + track);
        for (SubTrack subTrack : this.getSubTracks()) {
            subTrack.displaySubTrack();
        }
    }
}
