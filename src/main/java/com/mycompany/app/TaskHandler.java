package com.mycompany.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskHandler {
    public static class Task {
        private String description;
        private String priority;
        private boolean completed;

        public Task(String description, String priority) {
            this.description = description;
            this.priority = priority;
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }

        public String getPriority() {
            return priority;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }

    private List<Task> tasks = new ArrayList<>();

    public void addTask(String description, String priority) {
        tasks.add(new Task(description, priority));
    }

    public List<Task> getTasks() {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(Comparator.comparing(Task::getPriority));
        return sortedTasks;
    }

    public void completeTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).setCompleted(true);
        }
    }

    public void removeTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.remove(index - 1);
        }
    }

    public int getTaskCount() {
        return tasks.size();
    }
}