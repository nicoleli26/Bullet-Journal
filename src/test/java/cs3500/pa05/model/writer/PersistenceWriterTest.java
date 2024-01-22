package cs3500.pa05.model.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.entries.CommitmentWarnings;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.QuotesAndNotes;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.entries.Time;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersistenceWriterTest {
  List<Task> tasks;
  List<Event> events;
  Task task1 = new Task("Task 1", "", "Monday");
  Task task2 = new Task("Task 2", "", "Monday");
  Event event1 = new Event("Event 1", "", "Monday",
      new Time("3", "00", "PM"), 1.5);
  Event event2 = new Event("Event 2", "", "Monday",
      new Time("6", "00", "PM"), 2.0);
  PersistenceWriter persistenceWriter;

  private QuotesAndNotes quotesAndNotes;
  private CommitmentWarnings commitmentWarnings;

  @BeforeEach
  void setUp() {
    events = new ArrayList<>();
    tasks = new ArrayList<>();
    quotesAndNotes = new QuotesAndNotes("Description");
    tasks.add(task1);
    tasks.add(task2);
    events.add(event1);
    events.add(event2);
    commitmentWarnings = new CommitmentWarnings(10, 10);
    persistenceWriter = new PersistenceWriter(events, tasks, quotesAndNotes, commitmentWarnings);
  }

  @Test
  public void testException() {
    String invalidPath = "";

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setErr(new PrintStream(outputStream));

    persistenceWriter.write(invalidPath);

    String errorMessage = "Could not save your files.\n";
    assertEquals(errorMessage, outputStream.toString());
  }

  @Test
  void write() throws IOException {
    String filePath = "test.bujo";

    persistenceWriter.write(filePath);

    File outputFile = new File(filePath);
    assertTrue(outputFile.exists());

    String fileContent = Files.readString(Path.of(filePath));

    String expectedContent = """
        Your Events:
        Event : Event 1  Monday 3:00 PM 1.5
        Event : Event 2  Monday 6:00 PM 2.0
        Your Tasks:
        Task : Task 1  Monday
        Task : Task 2  Monday
        Your Quotes and Notes:\s
        Description
        Your Commitment Warnings:\s


        """;
    assertEquals(expectedContent, fileContent);
    assertTrue(outputFile.delete());
  }

  @Test
  public void testIoException() {
    String invalidpath = "";

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setErr(new PrintStream(outputStream));

    persistenceWriter.write(invalidpath);

    String errorMessage = "Could not save your files.\n";
    assertEquals(errorMessage, outputStream.toString());
  }

  @Test
  void testGetEvents() {
    events.add(event1);
    events.add(event2);

    List<Event> retrievedEvents = persistenceWriter.getEvents();
    assertEquals(events.size(), retrievedEvents.size());
    assertTrue(retrievedEvents.contains(event1));
    assertTrue(retrievedEvents.contains(event2));
  }

  @Test
  void testGetTasks() {

    List<Task> retrievedTasks = persistenceWriter.getTasks();
    assertEquals(tasks.size(), retrievedTasks.size());
    assertTrue(retrievedTasks.contains(task1));
    assertTrue(retrievedTasks.contains(task2));
  }

  @Test
  void testGetQuotesAndNotes() {
    QuotesAndNotes retrievedQuotesAndNotes = persistenceWriter.getQuotesAndNotes();
    assertNotNull(retrievedQuotesAndNotes);
    assertEquals(quotesAndNotes, retrievedQuotesAndNotes);
  }

  @Test
  void testGetCommitmentWarnings() {
    CommitmentWarnings retrievedCommitmentWarnings = persistenceWriter.getCommitmentWarnings();
    assertNotNull(retrievedCommitmentWarnings);
    assertEquals(commitmentWarnings, retrievedCommitmentWarnings);
  }

  @Test
  void testEquals() {
    PersistenceWriter writer1 =
        new PersistenceWriter(events, tasks, quotesAndNotes, commitmentWarnings);
    PersistenceWriter writer2 =
        new PersistenceWriter(events, tasks, quotesAndNotes, commitmentWarnings);
    PersistenceWriter writer3 =
        new PersistenceWriter(
            new ArrayList<>(), new ArrayList<>(), quotesAndNotes, commitmentWarnings);

    assertEquals(persistenceWriter, writer1);
    assertEquals(persistenceWriter, writer2);
    assertNotEquals(persistenceWriter, writer3);

    assertEquals(persistenceWriter, persistenceWriter);
    assertNotEquals(persistenceWriter, null);
    assertNotEquals(persistenceWriter, new Object());

    assertNotEquals(persistenceWriter,
        new PersistenceWriter(events, new ArrayList<>(), quotesAndNotes, commitmentWarnings));
    assertNotEquals(persistenceWriter,
        new PersistenceWriter(new ArrayList<>(), tasks, quotesAndNotes, commitmentWarnings));
  }

  @Test
  void testHashCode() {
    PersistenceWriter writer1 =
        new PersistenceWriter(events, tasks, quotesAndNotes, commitmentWarnings);
    PersistenceWriter writer2 =
        new PersistenceWriter(events, tasks, quotesAndNotes, commitmentWarnings);

    assertEquals(writer1.hashCode(), persistenceWriter.hashCode());
    assertEquals(writer2.hashCode(), persistenceWriter.hashCode());
  }
}

