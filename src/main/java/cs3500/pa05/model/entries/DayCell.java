package cs3500.pa05.model.entries;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a DayCell.
 * Each day contains a set of tasks and entries that
 * will be filled corresponding to the given day.
 */
public class DayCell {
  private Day day;
  private final List<Event> events;
  private final List<Task> tasks;

  /**
   * Constructor for a DayCell
   */
  public DayCell() {
    this.day = null;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  /**
   * Adds an event into a Days list of events
   *
   * @param e the event that wants to added.
   */
  public void addEvent(Event e) {
    events.add(e);
  }

  /**
   * Adds a task into a Days list of tasks.
   *
   * @param t the task that is added to a list of tasks.
   */
  public void addTask(Task t) {
    tasks.add(t);
  }

  /**
   * Sets the day to a given day.
   *
   * @param day The desired day.
   */
  public void setDay(Day day) {
    this.day = day;
  }

  /**
   * Returns the Tasks.
   *
   * @return the tasks
   */
  public List<Task> getTasks() {
    return tasks;
  }

  /**
   * Returns the Events
   *
   * @return the events
   */
  public List<Event> getEvents() {
    return events;
  }

  /**
   * Returns the Day
   *
   * @return the day
   */
  public Day getDay() {
    return day;
  }
}
