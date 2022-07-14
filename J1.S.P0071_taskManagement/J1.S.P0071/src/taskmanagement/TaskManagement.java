/*
 * Copyright(C) 2005, FPT University
 * J1.S.P0071
 * LAB211 Assignment J1.S.P0071
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-10-5                   1.0            NguyenThiNhu                  First Implement
 */
package taskmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class includes methods to add tasks, update tasks, delete tasks, get
 * data tasks, and main method display the functions of the task management
 * system and print the results of the user-requested functions to the screen.
 *
 * @author NguyenThiNhu
 */
public class TaskManagement {

    private final List<Task> taskList = new ArrayList<>();
    private final Validation validation = new Validation();

    /**
     * This method is used to add a Task on the program. Requires the user to
     * enter valid task information
     */
    private void addTask() {
        System.out.println("----------------Add Task----------------");
        Task task = new Task();
        if (taskList.isEmpty()) {
            task.setId(1);
        } else {
            task.setId(taskList.get(taskList.size() - 1).getId() + 1);
        }
        task.setRequirementName(validation.getStringType("Requirement Name: "));
        task.setTaskTypeId(validation.getTaskTypeId());
        task.setDate(validation.getDateType("Date(MMM-dd-yyy): "));
        task.setPlanFrom(validation.getPlanFrom());
        task.setPlanTo(validation.getPlanTo(task.getPlanFrom()));
        task.setAssignee(validation.getStringType("Assignee: "));
        task.setReviewer(validation.getStringType("Reviewer: "));
        taskList.add(task);
    }

    /**
     * This method is used to update a Task on the program. Ask the user to
     * enter a valid id and valid task information to update that task
     */
    private void updateTask() {
        System.out.println("----------------Update Task----------------");
        Scanner scanner = new Scanner(System.in);
        Task task = new Task();
        int index;
        while (true) {
            index = 0;
            task.setId(validation.getIntegerType("ID: "));
            for (Task object : taskList) {
                if (object.getId() == task.getId()) {
                    break;
                }
                index++;
            }
            if (index == taskList.size()) {
                System.out.println("Code does not exist");
            } else {
                break;
            }
        }
        task.setRequirementName(validation.getStringType("Requirement Name: "));
        task.setTaskTypeId(validation.getTaskTypeId());
        task.setDate(validation.getDateType("Date(MMM-dd-yyy): "));
        task.setPlanFrom(validation.getPlanFrom());
        task.setPlanTo(validation.getPlanTo(task.getPlanFrom()));
        task.setAssignee(validation.getStringType("Assignee: "));
        task.setReviewer(validation.getStringType("Reviewer: "));
        while (true) {
            System.out.print("Do you want to continue updating?(yes/no): ");
            String check = scanner.nextLine();
            if (check.equals("yes")) {
                taskList.set(index, task);
                System.out.println("Update successful !");
                break;
            }
            if (check.equals("no")) {
                break;
            }
        }
    }

    /**
     * This method is used to delete a Task on the program. Request input the id
     * of the task to delete, id must exist in the database
     */
    private void deleteTask() {
        System.out.println("----------------Delete Task----------------");
        Scanner scanner = new Scanner(System.in);
        int id = validation.getIntegerType("ID: ");
        while (true) {
            System.out.print("Do you want to continue delete?(yes/no): ");
            String check = scanner.nextLine();
            if (check.equals("yes")) {
                for (Task object : taskList) {
                    if (object.getId() == id) {
                        taskList.remove(object);
                        System.out.println("Delete successful !");
                        return;
                    }
                }
            }
            if (check.equals("no")) {
                break;
            }
        }
        System.out.println("Id does not exist, no deletion !");
    }

    /**
     * This method is used to show the task of descending according to the ID
     * and the required format interface.
     */
    private void getDataTasks() {
        System.out.println("----------------Task descending order----------------");
        System.out.printf("%-4s%-17s%-11s%-13s%-6s%-17s%-17s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (int i = taskList.size() - 1; i >= 0; i--) {
            System.out.println(taskList.get(i).toString());
        }
    }

    /**
     * This method displays a menu and asks the user to select an option. The
     * user runs the program. The program prompts the user to select an option.
     * User selects an option, performs the function of that option
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskManagement taskManagement = new TaskManagement();
        Validation validation = new Validation();
        while (true) {
            System.out.println("=============== Task program ==============\n"
                    + "1. Add Task\n"
                    + "2. Update Task\n"
                    + "3. Delete Task\n"
                    + "4. Display Task\n"
                    + "5. Exit");
            int option = 0;
            while (true) {
                option = validation.getIntegerType("Your choice: ");
                if (option >= 1 && option <= 5) {
                    break;
                }
            }
            switch (option) {
                case 1:
                    taskManagement.addTask();
                    break;
                case 2:
                    taskManagement.updateTask();
                    break;
                case 3:
                    taskManagement.deleteTask();
                    break;
                case 4:
                    taskManagement.getDataTasks();
                    break;
                case 5:
                    return;
            }
        }

    }

}
