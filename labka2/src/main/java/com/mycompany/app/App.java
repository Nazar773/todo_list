package com.mycompany.app;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskHandler handler = new TaskHandler();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (High/Low): ");
                    String priority = scanner.nextLine();
                    if (priority.equalsIgnoreCase("High") || priority.equalsIgnoreCase("Low")) {
                        handler.addTask(description, priority);
                        System.out.println("Task '" + description + "' added with priority " + priority + ".");
                    } else {
                        System.out.println("Priority must be 'High' or 'Low'.");
                    }
                    break;
                case "2":
                    List<TaskHandler.Task> tasks = handler.getTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nTo-Do List (Sorted by Priority):");
                        for (int i = 0; i < tasks.size(); i++) {
                            TaskHandler.Task task = tasks.get(i);
                            String status = task.isCompleted() ? "Completed" : "Pending";
                            System.out.printf("%d. %s (Priority: %s, Status: %s)\n",
                                    i + 1, task.getDescription(), task.getPriority(), status);
                        }
                    }
                    break;
                case "3":
                    handler.getTasks();
                    System.out.print("Enter task number to mark as completed: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        handler.completeTask(index);
                        System.out.println("Task marked as completed.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;
                case "4":
                    handler.getTasks();
                    System.out.print("Enter task number to remove: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        handler.removeTask(index);
                        System.out.println("Task removed.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;
                case "5":
                    System.out.println("Exiting To-Do List Manager.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}