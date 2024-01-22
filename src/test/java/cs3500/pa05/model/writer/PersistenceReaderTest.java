package cs3500.pa05.model.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.PersistenceReader;
import cs3500.pa05.model.entries.CommitmentWarnings;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.QuotesAndNotes;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.entries.Time;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Represents any tests in a Persistence reader.
 */
class PersistenceReaderTest {
  PersistenceReader persistenceReader = new PersistenceReader();
  Time time = new Time("12", "30", "PM");
  Event event = new Event("Lecture", "MVC", "Sunday", time, 45);
  List<Event> events = new ArrayList<>(List.of(event));
  Task task = new Task("Homework 5", "Chapter 5.1", "Friday");
  List<Task> tasks = new ArrayList<>(List.of(task));

  PersistenceWriter writer =
      new PersistenceWriter(events, tasks, new QuotesAndNotes(""), new CommitmentWarnings(5, 5));

  @Test
  public void testRead() {
    writer.write("example.bujo");

    persistenceReader.read("example.bujo");

    assertEquals(new ArrayList<>(List.of("Lecture MVC Sunday 12:30 PM 45.0")),
        persistenceReader.getEventList());
    assertEquals(new ArrayList<>(List.of("Homework 5 Chapter 5.1 Friday")),
        persistenceReader.getTaskList());

  }

  @Test
  public void testReaderThrows() {
    String invalidPath = "";

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setErr(new PrintStream(outputStream));

    persistenceReader.read(invalidPath);
    String errorMessage = "Cannot read your file\n";
    assertEquals(errorMessage, outputStream.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(persistenceReader, persistenceReader);
    assertNotEquals(null, persistenceReader);
    assertNotEquals(persistenceReader, new Object());
    assertEquals(persistenceReader, new PersistenceReader());
    assertTrue(persistenceReader.equals(persistenceReader));

  }
}