package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskHandlerTest {
    private TaskHandler handler;

    @Before
    public void setUp() {
        handler = new TaskHandler();
    }

    @Test
    public void testAddTask() {
        handler.addTask("Test Task", "Low");
        assertEquals(1, handler.getTaskCount());
        assertEquals("Test Task", handler.getTasks().get(0).getDescription());
        assertEquals("Low", handler.getTasks().get(0).getPriority());
        assertFalse(handler.getTasks().get(0).isCompleted());
    }

    @Test
    public void testCompleteTask() {
        handler.addTask("Test Task", "High");
        handler.completeTask(1);
        assertTrue(handler.getTasks().get(0).isCompleted());
    }

    @Test
    public void testRemoveTask() {
        handler.addTask("Test Task", "Low");
        handler.removeTask(1);
        assertEquals(0, handler.getTaskCount());
    }

    @Test
    public void testGetTasksEmpty() {
        assertEquals(0, handler.getTaskCount());
    }

    @Test
    public void testTaskSorting() {
        handler.addTask("Task 1", "Low");
        handler.addTask("Task 2", "High");
        assertEquals("High", handler.getTasks().get(0).getPriority());
        assertEquals("Low", handler.getTasks().get(1).getPriority());
    }
}