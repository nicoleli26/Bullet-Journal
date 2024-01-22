package cs3500.pa05.model.entries;

/**
 * Represents the abstract class for any entry creation.
 */
public abstract class AbstractEntry {
  private Day day;
  private String name;
  private String description;

  /**
   * Represents the creation of an entry.
   *
   * @param name        the name of the event/task
   * @param description the description of the event/task
   * @param day         the day of the event/task
   */
  public AbstractEntry(String name, String description, String day) {
    this.name = name;
    this.description = description;
    this.day = stringToDay(day);
  }

  /**
   * Allows user to enter a String format of a Day, which is then converted into a Day.
   *
   * @param dayName the string format of a Day
   * @return the Day format of the string.
   */
  private Day stringToDay(String dayName) {
    if (dayName.equalsIgnoreCase("Sunday")) {
      return Day.Sunday;
    }
    if (dayName.equalsIgnoreCase("Monday")) {
      return Day.Monday;
    }
    if (dayName.equalsIgnoreCase("Tuesday")) {
      return Day.Tuesday;
    }
    if (dayName.equalsIgnoreCase("Wednesday")) {
      return Day.Wednesday;
    }
    if (dayName.equalsIgnoreCase("Thursday")) {
      return Day.Thursday;
    }
    if (dayName.equalsIgnoreCase("Friday")) {
      return Day.Friday;
    }
    if (dayName.equalsIgnoreCase("Saturday")) {
      return Day.Saturday;
    } else {
      throw new IllegalArgumentException("String is not a proper day");
    }
  }

  /**
   * Retrieves the name of a Task/Event
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieves the description of a Task/Event
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Retrieves the day of the Event/Task
   *
   * @return the day
   */
  public Day getDay() {
    return day;
  }
}

