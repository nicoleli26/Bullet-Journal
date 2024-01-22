package cs3500.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.entries.AbstractEntry;
import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.DayCell;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.entries.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents any tests for an AbstractEntry and its subclasses.
 */
class AbstractEntryTest {
  AbstractEntry event;
  Time time;
  AbstractEntry task;

  @BeforeEach
  public void setUp() {
    time = new Time("11", "40", "AM");
    event = new Event("CS 3500 Lecture", "Lecture: MVC",
        "Thursday", time, 140);
    task = new Task("PA05", "Complete Model", "Thursday");
  }

  @Test
  public void testGetName() {
    assertEquals("CS 3500 Lecture", event.getName());
    assertEquals("PA05", task.getName());
  }

  @Test
  public void testGetDescription() {
    assertEquals("Lecture: MVC", event.getDescription());
    assertEquals("Complete Model", task.getDescription());
  }

  @Test
  public void testGetDay() {
    assertEquals(Day.Thursday, event.getDay());
    assertEquals(Day.Thursday, task.getDay());
    task = new Task("PA05", "Complete Model", "Friday");
    assertEquals(Day.Friday, task.getDay());
    task = new Task("PA05", "Complete Model", "saturday");
    assertEquals(Day.Saturday, task.getDay());
    task = new Task("PA05", "Complete Model", "tuesday");
    assertEquals(Day.Tuesday, task.getDay());
    task = new Task("PA05", "Complete Model", "Sunday");
    assertEquals(Day.Sunday, task.getDay());
    task = new Task("PA05", "Complete Model", "wednesday");
    assertEquals(Day.Wednesday, task.getDay());
  }

  @Test
  public void testStringToDayException() {
    assertThrows(IllegalArgumentException.class, () ->
      new Task("", "", ""));
  }
}