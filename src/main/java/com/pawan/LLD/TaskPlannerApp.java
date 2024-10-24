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
        planner.createTask("FEATURE-1", "Feature 1 title", "Pawan", TaskType.FEATURE, new Date(new Date().getTime() + 10*60*1000), "Summary of feature", "HIGH");
        planner.createTask("FEATURE-2", "Feature 2 title", "Viman", TaskType.FEATURE, new Date(), "Summary of feature", "HIGH");
        planner.createTask("BUG-1", "Bug 1 title", "Saini", TaskType.BUG, new Date(new Date().getTime() + 10*60*1000), "P1");
        planner.createTask("STORY-1" ,"Story 1 title", "Kumar", TaskType.STORY, new Date(new Date().getTime() + 10*60*1000), "Story Summary 1");

        // subtracks
        planner.createSubTrack("STORY-1", "SubTrack 1");
        planner.createSubTrack("STORY-1", "SubTrack 2");

        planner.createSprint("Sprint 1");
        planner.addTaskToSprint("Sprint 1", "FEATURE-1");
        planner.addTaskToSprint("Sprint 1", "FEATURE-2");
        planner.addTaskToSprint("Sprint 1", "STORY-1");
        planner.addTaskToSprint("Sprint 1", "BUG-1");

        System.out.println("Below sprint task created : ");
        planner.displaySprintSnapshot("Sprint 1");

        // Display tasks for user

        planner.displaySprintSnapshot("Sprint 1");
        planner.changeAssignee("FEATURE-2", "Ryan");
        planner.changeAssignee("STORY-1", "Peter");
        System.out.println("User task after assignee change : ");
        planner.displayTasksForUser("Pawan");
        planner.displayTasksForUser("Ryan");
        planner.displayTasksForUser("Peter");

        // Display sprint snapshot
        System.out.println("Sprint task after assignee change : ");
        planner.displaySprintSnapshot("Sprint 1");

        // remove task from sprint
        planner.addTaskToSprint("Sprint 1", "FEATURE-2");
        planner.addTaskToSprint("Sprint 1", "BUG-1");

        // Display sprint snapshot
        System.out.println("Sprint task after remove task from sprint : ");
        planner.displaySprintSnapshot("Sprint 1");
    }

    public static void testCase2() throws Exception {
        TaskPlanner planner = new TaskPlanner();

        // create task
        planner.createTask("FEATURE-1", "Feature 1 title", "Pawan", TaskType.FEATURE, new Date(), "Summary of feature", "HIGH");
        planner.createTask("FEATURE-2", "Feature 2 title", "Viman", TaskType.FEATURE, new Date(), "Summary of feature", "HIGH");
        planner.createTask("BUG-1","Bug 1 title", "Saini", TaskType.BUG, new Date(), "P1");
        planner.createTask("STORY-1", "Story 1 title", "Kumar", TaskType.STORY, new Date(), "Story Summary 1");

        planner.createSprint("Sprint 2");
        planner.addTaskToSprint("Sprint 2", "FEATURE-1");
        planner.addTaskToSprint("Sprint 2", "FEATURE-2");
        planner.addTaskToSprint("Sprint 2", "STORY-1");
        planner.addTaskToSprint("Sprint 2", "BUG-1");

        // Display sprint snapshot
        System.out.println("Below sprint task created : ");
        planner.displaySprintSnapshot("Sprint 2");

        // Create Bug Feature
        planner.displayTasksForUser("Pawan");
        planner.addTaskStatus(TaskStatus.IN_PROGRESS, "FEATURE-1");
        planner.displayTasksForUser("Pawan");
        planner.addTaskStatus(TaskStatus.DEPLOYED, "FEATURE-1"); // Valid
        planner.displayTasksForUser("Pawan");

        // Create Bug Task
        planner.displayTasksForUser("Saini");
        planner.addTaskStatus(TaskStatus.FIXED, "BUG-1");
        planner.displayTasksForUser("Saini");
        planner.addTaskStatus(TaskStatus.COMPLETED, "BUG-1");
        planner.displayTasksForUser("Saini");

        // Create Story Task
        planner.displayTasksForUser("Kumar");
        planner.addTaskStatus(TaskStatus.COMPLETED, "STORY-1");
        planner.displayTasksForUser("Kumar");
        planner.addTaskStatus(TaskStatus.FIXED, "STORY-1");
        planner.displayTasksForUser("Kumar");

        System.out.println("Sprint task after sprint task status update : ");
        planner.displaySprintSnapshot("Sprint 2");
    }
}
