package com.pawan.LLD.dto;

import com.pawan.LLD.enums.TaskStatus;
import lombok.Data;


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

    protected void displaySubTrack() {
        System.out.println("SubTrack: " + this.getTitle() + ", Status: " + this.getStatus());
    }
}
