package cs3500.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.entries.Time;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for TimeClass
 */
class TimeTest {
  Time time;
  Time time2;

  @Test
  public void testValidTime() {
    time = new Time("12", "30", "pm");
    assertEquals("12", time.getHour());
    assertEquals("30", time.getMinutes());
    assertEquals("pm", time.getZone());
    time2 = new Time("12", "30", "Am");
    assertEquals("Am", time2.getZone());
  }

  @Test
  public void testValidateHourThrows() {
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("14", "30", "Am"));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("-10", "30", "Am"));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time(null, "30", "Am"));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("", "30", "Am"));
  }

  @Test
  public void testValidateMinutesThrows() {
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("11", "70", "PM"));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("11", "-01", "PM"));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("11", null, "PM"));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("11", "", "PM"));
  }

  @Test
  public void testValidateZoneThrows() {
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("12", "30", "h"));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("12", "30", null));
    assertThrows(UnsupportedOperationException.class, () -> time = new Time("12", "30", ""));
  }

  @Test
  public void testToString() {
    time = new Time("12", "30", "pm");
    assertEquals("12:30 pm", time.toString());
  }
}