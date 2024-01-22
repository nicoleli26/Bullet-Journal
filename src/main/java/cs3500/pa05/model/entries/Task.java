package cs3500.pa05.model.entries;

import java.util.Objects;

/**
 * Represents the creation of a Task
 */
public class Task extends AbstractEntry {
  private boolean isComplete;

  /**
   * Represents the creation of a Task/Event.
   *
   * @param name        the name of the event/task
   * @param description the description of the event/task
   * @param day         the day of the event/task
   */

  public Task(String name, String description, String day) {
    super(name, description, day);
    this.isComplete = false;
  }

  /**
   * Retrieves the complete status of a task.
   *
   * @return whether the task is complete or not.
   */
  public boolean getIsComplete() {
    return isComplete;
  }

  /**
   * Marks a Task as complete.
   */
  public void markAsComplete() {
    isComplete = true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Task t)) {
      return false;
    }
    return getName().equals(t.getName()) && getDescription().equals(t.getDescription())
        && getDay().equals(t.getDay()) && isComplete == t.getIsComplete();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDescription(), getDay(), isComplete);
  }

  @Override
  public String toString() {
    return "Task : " + getName() + " " + getDescription() + " " + getDay();
  }
}
