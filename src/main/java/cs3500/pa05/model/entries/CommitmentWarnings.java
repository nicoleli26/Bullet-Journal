package cs3500.pa05.model.entries;

import java.util.Objects;

/**
 * Represents the Commitment Warnings that a user wants to set.
 */
public class CommitmentWarnings {
  private final int maxTasks;
  private final int maxEvents;

  /**
   * Constructor for the Commitment Warnings.
   *
   * @param maxTasks  the maximum tasks
   * @param maxEvents the maixmum events
   */
  public CommitmentWarnings(int maxTasks, int maxEvents) {
    this.maxTasks = maxTasks;
    this.maxEvents = maxEvents;
  }

  /**
   * Compares the current number of tasks/events to the max
   *
   * @param maxAmount     the maximum number of entries
   * @param currentAmount the current number of entries
   * @return the number of remaining number of entries
   */
  public boolean validNumberOfTasksOrEvents(int maxAmount, int currentAmount) {
    return (currentAmount <= maxAmount);
  }

  /**
   * Returns the maximum number of events
   *
   * @return the max number of events
   */
  public int getMaxEvents() {
    return this.maxEvents;
  }

  /**
   * Returns the maximum number of tasks
   *
   * @return the max number of tasks
   */
  public int getMaxTasks() {
    return this.maxTasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommitmentWarnings c)) {
      return false;
    }
    return getMaxEvents() == (c.getMaxEvents()) && getMaxTasks() == (c.getMaxTasks());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMaxEvents(), getMaxTasks());
  }
}

