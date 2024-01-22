package cs3500.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.DayCell;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.entries.Time;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayCellTest {
  List<Task> tasks = new ArrayList<>();
  List<Event> events = new ArrayList<>();
  Task task1 = new Task("Task 1", "", "Monday");
  Task task2 = new Task("Task 2", "", "Monday");
  Event event1 = new Event("Event 1", "", "Monday",
      new Time("3", "00", "PM"), 1.5);
  Event event2 = new Event("Event 2", "", "Monday",
      new Time("6", "00", "PM"), 2.0);
  DayCell dayCell;

  @BeforeEach
  void setUp() {
    tasks.add(task1);
    tasks.add(task2);
    events.add(event1);
    events.add(event2);
    dayCell = new DayCell();
  }

  @Test
  public void testSetDay() {
    dayCell.setDay(Day.Monday);
    assertEquals(Day.Monday, dayCell.getDay());
  }

  @Test
  public void testSetEvent() {
    dayCell.addEvent(event1);
    dayCell.addEvent(event2);
    assertEquals(events, dayCell.getEvents());
  }

  @Test
  public void testSetTasks() {
    dayCell.addTask(task1);
    dayCell.addTask(task2);
    assertEquals(tasks, dayCell.getTasks());
  }
}