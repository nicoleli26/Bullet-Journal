package cs3500.pa05.model.entries;

/**
 * Represents the entry of Time in a BulletJournal.
 */
public class Time {
  private final String hour;
  private final String minutes;
  private final String zone;

  /**
   * Constructor for Time.
   *
   * @param hour    the hour aspect of time ranging from 00 -> 12
   * @param minutes the minutes aspect of time ranging from 00 -> 59
   * @param zone    the time zone aspect of time, either AM or PM.
   */
  public Time(String hour, String minutes, String zone) {
    this.hour = validateHours(hour);
    this.minutes = validateMinutes(minutes);
    this.zone = validateZone(zone);
  }

  /**
   * Retrieves the hours aspect of a time entry.
   *
   * @return the hour aspect of time.
   */
  public String getHour() {
    return hour;
  }

  /**
   * Retrieves the minutes aspect of a time entry.
   *
   * @return the minutes aspect of time.
   */
  public String getMinutes() {
    return minutes;
  }

  /**
   * Retrieves the zone aspect of a time entry.
   *
   * @return the zone aspect of time.
   */
  public String getZone() {
    return zone;
  }

  /**
   * Validates the given hour. Ensures that the hour component of time is neither null
   * nor invalid.
   *
   * @param hour if the given hour is valid
   */
  private String validateHours(String hour) {
    if (hour == null || hour.isEmpty()) {
      throw new UnsupportedOperationException("Please submit a valid hour");
    }
    int hourNum = Integer.parseInt(hour);
    if (hourNum < 0 || hourNum > 12) {
      throw new UnsupportedOperationException("Please submit a valid hour");
    } else {
      return hour;
    }
  }

  /**
   * Validates the given minutes. Ensures that the minutes component of time is neither null
   * nor invalid.
   *
   * @param minutes if the given minutes is valid
   */
  private String validateMinutes(String minutes) {
    if (minutes == null || minutes.isEmpty()) {
      throw new UnsupportedOperationException("Please submit a valid minute");
    }
    int minuteNum = Integer.parseInt(minutes);
    if (minuteNum < 0 || minuteNum > 59) {
      throw new UnsupportedOperationException("Please submit a valid minute");
    } else {
      return minutes;
    }
  }

  /**
   * Validates the given zone. Ensures that the zone component of time is neither null
   * nor invalid.
   *
   * @param zone if the given zone is valid
   */
  private String validateZone(String zone) {
    if (zone == null || zone.isEmpty()) {
      throw new UnsupportedOperationException("Please submit a valid zone");
    }
    if (!(zone.equalsIgnoreCase("AM")) && !(zone.equalsIgnoreCase("PM"))) {
      throw new UnsupportedOperationException("Please submit a valid zone");
    } else {
      return zone;
    }
  }

  /**
   * Converts a Time entry into a String structured as HH:MM AM/PM
   *
   * @return the string format of time.
   */
  @Override
  public String toString() {
    return hour + ":" + minutes + " " + zone;
  }
}
