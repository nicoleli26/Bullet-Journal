package cs3500.pa05.model.entries;

/**
 * Represents a WeekDay.
 */
public enum Day {
  /**
   * Represents Monday
   */
  Monday("Monday"),
  /**
   * Represents Tuesday
   */
  Tuesday("Tuesday"),
  /**
   * Represents Wednesday
   */
  Wednesday("Wednesday"),
  /**
   * Represents Thursday
   */
  Thursday("Thursday"),
  /**
   * Represents Friday
   */
  Friday("Friday"),
  /**
   * Represents Saturday
   */
  Saturday("Saturday"),
  /**
   * Represents Sunday
   */
  Sunday("Sunday");
  private final String dayName;

  /**
   * Constructor for a Day
   *
   * @param dayName the string format of the day's name.
   */
  Day(String dayName) {
    this.dayName = dayName;
  }

}
