package cs3500.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.entries.TaskQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the TaskQueue class
 */
class TaskQueueTest {
  TaskQueue taskQueue;
  Task task;

  @BeforeEach
  void setUp() {
    taskQueue = new TaskQueue();
    task = new Task("PA05", "Complete Model", "Thursday");
  }

  @Test
  void mapper() {
    taskQueue.addTask(task);
    assertEquals(false, taskQueue.mapper().get("PA05"));

  }

  @Test
  void addTask() {
    assertTrue(taskQueue.getTaskQueue().isEmpty());
    taskQueue.addTask(task);
    assertFalse(taskQueue.getTaskQueue().isEmpty());
  }

  @Test
  void removeTask() {
    taskQueue.addTask(task);
    assertFalse(taskQueue.getTaskQueue().isEmpty());
    taskQueue.removeTask(task);
    assertTrue(taskQueue.getTaskQueue().isEmpty());
  }
}