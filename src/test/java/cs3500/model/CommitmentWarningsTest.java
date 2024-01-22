package cs3500.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.entries.CommitmentWarnings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents any tests for commitment warnings
 */
class CommitmentWarningsTest {
  CommitmentWarnings commitmentWarnings;

  @BeforeEach
  void setUp() {
    commitmentWarnings = new CommitmentWarnings(4, 5);
  }

  @Test
  void validNumberOfTasksOrEvents() {
    assertFalse(commitmentWarnings.validNumberOfTasksOrEvents(4, 5));
    assertTrue(commitmentWarnings.validNumberOfTasksOrEvents(4, 4));
    assertTrue(commitmentWarnings.validNumberOfTasksOrEvents(4, 3));
  }

  @Test
  void getMaxEvents() {
    assertEquals(5, commitmentWarnings.getMaxEvents());
  }

  @Test
  void getMaxTasks() {
    assertEquals(4, commitmentWarnings.getMaxTasks());
  }

  @Test
  public void testEquals_ReturnsTrue() {
    assertEquals(commitmentWarnings, commitmentWarnings);
    assertEquals(commitmentWarnings, new CommitmentWarnings(4, 5));
  }

  @Test
  public void testEquals_DifferentObjects() {
    assertNotEquals(commitmentWarnings, new Object());
  }

  @Test
  public void testEquals_DifferentMaxEvents() {
    assertNotEquals(commitmentWarnings, new CommitmentWarnings(4, 4));
  }

  @Test
  public void testEquals_DifferentMaxTasks() {
    assertNotEquals(commitmentWarnings, new CommitmentWarnings(5, 5));
  }

  @Test
  void testHashCode() {
    CommitmentWarnings commitmentWarnings1 = new CommitmentWarnings(4, 5);
    CommitmentWarnings commitmentWarnings2 = new CommitmentWarnings(4, 5);
    assertEquals(commitmentWarnings1.hashCode(), commitmentWarnings2.hashCode());
  }
}