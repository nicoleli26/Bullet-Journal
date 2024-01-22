package cs3500.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the Event class.
 */
class EventTest {
  Event event;
  Event event2;
  Time time;
  Time time2;

  @BeforeEach
  public void setUp() {
    time = new Time("11", "40", "AM");
    time2 = new Time("4", "45", "pm");
    event = new Event("CS 3500 Lecture", "Lecture: MVC", "Thursday", time, 140);
    event2 = new Event("Meeting with group", "work on PA05", "Monday", time, 50);
  }

  @Test
  public void testGetTime() {
    assertEquals(time, event.getTime());
  }

  @Test
  public void getDuration() {
    assertEquals(140, event.getDuration());
  }

  @Test
  public void testEquals_ReturnsTrue() {
    assertEquals(event, event);
    assertEquals(event, new Event("CS 3500 Lecture", "Lecture: MVC", "Thursday", time, 140));
  }

  @Test
  public void testEquals_DifferentEvents() {
    assertNotEquals(event, event2);
  }

  @Test
  public void testEquals_DifferentObjects() {
    assertNotEquals(event, new Object());
  }

  @Test
  public void testEquals_DifferentName() {
    assertNotEquals(event, new Event("OOD", "Lecture: MVC", "Thursday", time, 140));
  }

  @Test
  public void testEquals_DifferentDescription() {
    assertNotEquals(event, new Event("CS 3500 Lecture", "", "Thursday", time, 140));
  }

  @Test
  public void testEquals_DifferentDay() {
    assertNotEquals(event, new Event("CS 3500 Lecture", "Lecture: MVC", "Monday", time, 140));
  }

  @Test
  public void testEquals_DifferentTime() {
    assertNotEquals(event, new Event("CS 3500 Lecture", "Lecture: MVC", "Thursday", time2, 140));
  }

  @Test
  public void testEquals_DifferentDuration() {
    assertNotEquals(event, new Event("CS 3500 Lecture", "Lecture: MVC", "Thursday", time, 30));
  }

  @Test
  public void testHash() {
    Event event1 = new Event("CS 3500 Lecture", "Lecture: MVC", "Thursday", time, 140);
    Event event2 = new Event("CS 3500 Lecture", "Lecture: MVC", "Thursday", time, 140);
    assertEquals(event1.hashCode(), event2.hashCode());
  }
}