package cs3500.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for Tasks.
 */
class TaskTest {
  Task task;

  @BeforeEach
  public void setUp() {
    task = new Task("PA05", "Complete Model", "Thursday");
  }

  @Test
  public void getIsComplete() {
    assertFalse(task.getIsComplete());
    task.markAsComplete();
    assertTrue(task.getIsComplete());
  }

  @Test
  public void testEquals_ReturnsTrue() {
    assertEquals(task, task);
    assertEquals(task, new Task("PA05", "Complete Model", "Thursday"));
  }

  @Test
  public void testEquals_DifferentObjects() {
    assertNotEquals(task, new Object());
  }

  @Test
  public void testEquals_DifferentName() {
    assertNotEquals(task, new Task("HW04", "Complete Model", "Thursday"));
  }

  @Test
  public void testEquals_DifferentDescription() {
    assertNotEquals(task, new Task("PA05", "", "Thursday"));
  }

  @Test
  public void testEquals_DifferentDay() {
    assertNotEquals(task, new Task("PA05", "Complete Model", "Monday"));
  }

  @Test
  public void testEquals_DifferentComplete() {
    Task complete = new Task("PA05", "Complete Model", "Thursday");
    complete.markAsComplete();
    assertNotEquals(task, complete);
  }

  @Test
  public void testHash() {
    Task task1 = new Task("PA05", "Complete Model", "Thursday");
    Task task2 = new Task("PA05", "Complete Model", "Thursday");
    assertEquals(task1.hashCode(), task2.hashCode());
  }
}