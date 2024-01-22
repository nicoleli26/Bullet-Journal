package cs3500.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cs3500.pa05.model.entries.QuotesAndNotes;
import cs3500.pa05.model.entries.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuotesAndNotesTest {
  QuotesAndNotes quotesAndNotes;

  @BeforeEach
  void setUp() {
    quotesAndNotes = new QuotesAndNotes("Finish PA05");
  }

  @Test
  public void testEquals_ReturnsTrue() {
    assertEquals(quotesAndNotes, quotesAndNotes);
    assertEquals(quotesAndNotes, new QuotesAndNotes("Finish PA05"));
  }

  @Test
  public void testEquals_DifferentObjects() {
    assertNotEquals(quotesAndNotes, new Object());
  }

  @Test
  public void testEquals_DifferentDescription() {
    assertNotEquals(quotesAndNotes, new QuotesAndNotes("Different"));
  }

  @Test
  public void testHash() {
    QuotesAndNotes quotesAndNotes1 = new QuotesAndNotes("PA05");
    QuotesAndNotes quotesAndNotes2 = new QuotesAndNotes("PA05");
    assertEquals(quotesAndNotes1.hashCode(), quotesAndNotes2.hashCode());
  }
}