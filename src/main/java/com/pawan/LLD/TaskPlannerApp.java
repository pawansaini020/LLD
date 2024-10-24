package com.pawan.LLD;

import com.pawan.LLD.dto.Feature;
import com.pawan.LLD.dto.Task;
import com.pawan.LLD.enums.TaskStatus;
import com.pawan.LLD.enums.TaskType;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 24/10/24.
 */
public class TaskPlannerApp {

    public static void main(String[] args) {
        try {

            test1();
            testCase2();
        } catch (Exception e) {
            System.out.println("Error while running task planner");
        }
    }

    public static void test1() {
        TaskPlanner planner = new TaskPlanner();

        // create task
        planner.createTask("Feature 1", "Pawan", TaskType.FEATURE, new Date(), "Summary of feature", "HIGH");
        planner.createTask("Feature 2", "Viman", TaskType.FEATURE, new Date(), "Summary of feature", "HIGH");
        planner.createTask("Bug 1", "Saini", TaskType.BUG, new Date(), "P1");
        planner.createTask("Story 1", "Kumar", TaskType.STORY, new Date(), "Story Summary 1");

        // subtracks
        planner.createSubTrack("Story 1", "SubTrack 1");
        planner.createSubTrack("Story 1", "SubTrack 2");

        planner.createSprint("Sprint 1");
        planner.addTaskToSprint("Sprint 1", "Feature 1");
        planner.addTaskToSprint("Sprint 1", "Story 1");

        // Display tasks for user
        planner.changeAssignee("Feature 2", "Ryan");
        planner.changeAssignee("Story 1", "Peter");
        planner.displayTasksForUser("Pawan");
        planner.displayTasksForUser("Ryan");
        planner.displayTasksForUser("Peter");

        // Display sprint snapshot
        planner.displaySprintSnapshot("Sprint 1");
    }

    public static void testCase2() throws Exception {
        TaskPlanner planner = new TaskPlanner();

        // create task
        planner.createTask("Feature 1", "Pawan", TaskType.FEATURE, new Date(), "Summary of feature", "HIGH");
        planner.createTask("Feature 2", "Viman", TaskType.FEATURE, new Date(), "Summary of feature", "HIGH");
        planner.createTask("Bug 1", "Saini", TaskType.BUG, new Date(), "P1");
        planner.createTask("Story 1", "Kumar", TaskType.STORY, new Date(), "Story Summary 1");

        // subtracks
        planner.createSubTrack("Story 1", "SubTrack 1");
        planner.createSubTrack("Story 1", "SubTrack 2");

        planner.createSprint("Sprint 1");
        planner.addTaskToSprint("Sprint 1", "Feature 1");
        planner.addTaskToSprint("Sprint 1", "Feature ");
        planner.addTaskToSprint("Sprint 1", "Story 1");
        planner.addTaskToSprint("Sprint 1", "Bug 1");

        // Display sprint snapshot
        planner.displaySprintSnapshot("Sprint 1");

        // Create Bug Feature
        planner.displayTasksForUser("Pawan");
        planner.addTaskStatus(TaskStatus.IN_PROGRESS, "Feature 1");
        planner.displayTasksForUser("Pawan");
        planner.addTaskStatus(TaskStatus.DEPLOYED, "Feature 1"); // Valid
        planner.displayTasksForUser("Pawan");

        // Create Bug Task
        planner.displayTasksForUser("Saini");
        planner.addTaskStatus(TaskStatus.FIXED, "Bug 1");
        planner.displayTasksForUser("Saini");
        planner.addTaskStatus(TaskStatus.COMPLETED, "Bug 1");
        planner.displayTasksForUser("Saini");

        // Create Story Task
        planner.displayTasksForUser("Kumar");
        planner.addTaskStatus(TaskStatus.COMPLETED, "Story 1");
        planner.displayTasksForUser("Kumar");
        planner.addTaskStatus(TaskStatus.FIXED, "Story 1");
        planner.displayTasksForUser("Kumar");

    }
}
