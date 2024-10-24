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

    public Story(String title, String creator, Date dueDate) {
        super(title, creator, TaskType.STORY, dueDate);
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
}
