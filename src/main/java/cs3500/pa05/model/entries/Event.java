package cs3500.pa05.model.entries;

import java.util.Objects;

/**
 * Represents the creation of an Event
 */
public class Event extends AbstractEntry {
  private final Time time;
  private final double duration;

  /**
   * Represents the creation of a Task/Event.
   *
   * @param name        the name of the event/task
   * @param description the description of the event/task
   * @param day         the day of the event/task
   * @param time        the startTime and duration of the event/task
   * @param duration    the duration of an event
   */

  public Event(String name, String description, String day, Time time, double duration) {
    super(name, description, day);
    this.time = time;
    this.duration = duration;
  }

  /**
   * Retrieves the Time entry of an Event.
   *
   * @return the time entry of an Event.
   */
  public Time getTime() {
    return time;
  }

  /**
   * Retrieves the Duration entry of an Event.
   *
   * @return the duration entry of an event.
   */
  public double getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Event e)) {
      return false;
    }
    return getName().equals(e.getName()) && getDescription().equals(e.getDescription())
        && getDay().equals(e.getDay()) && time.equals(e.getTime()) && duration == e.getDuration();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDescription(), getDay(), time, duration);
  }

  @Override
  public String toString() {
    return "Event : " + getName() + " " + getDescription() + " "
        + getDay() + " " +  time.toString() + " " + duration;
  }
}
