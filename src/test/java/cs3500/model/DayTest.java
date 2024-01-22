package cs3500.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.entries.Day;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents any tests for Day.
 */
class DayTest {
  Day day;

  @BeforeEach
  public void setUp() {
    day = Day.Friday;
  }

  @Test
  public void testGetName() {
    assertEquals("Friday", day.name());
  }
}