package cs3500.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.PersistenceReader;
import cs3500.pa05.model.entries.CommitmentWarnings;
import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.QuotesAndNotes;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.entries.Time;
import cs3500.pa05.model.writer.PersistenceWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Test class for BulletJournal
 */
class BulletJournalTest {
  Time time = new Time("12", "30", "PM");
  BulletJournal bulletJournal = new BulletJournal();
  Event event = new Event("", "", "monday", time, 30);
  Task task = new Task("", "", "Monday");

  @Test
  public void testAddEvent() {
    bulletJournal.addEvent(event);
    System.out.println(bulletJournal.getDayCell()[1]);
  }

  @Test
  public void testAddTask() {
    bulletJournal.addTask(task);
    System.out.println(bulletJournal.getDayCell()[0]);
  }

  @Test
  public void testGetAllEvents() {
    bulletJournal.addEvent(event);
    List<Event> testListOfEvents = new ArrayList<>();
    testListOfEvents.add(event);
    assertEquals(testListOfEvents, bulletJournal.getAllEvents());
  }

  @Test
  public void testGetAllTasks() {
    bulletJournal.addTask(task);
    List<Task> testListOfTasks = new ArrayList<>();
    testListOfTasks.add(task);
    assertEquals(testListOfTasks, bulletJournal.getAllTasks());
  }

  @Test
  public void testGetNumberOfCompletedTasks() {
    assertEquals(0, bulletJournal.getNumberOfCompleteTasks());
    bulletJournal.addTask(task);
    Task task2 = new Task("", "", "Monday");
    task2.markAsComplete();
    bulletJournal.addTask(task2);
    assertEquals(1, bulletJournal.getNumberOfCompleteTasks());
  }

  @Test
  public void testSetQuotesAndNotes() {
    QuotesAndNotes quotes = new QuotesAndNotes("Slay");
    bulletJournal.setQuotesAndNotes("Slay");
    assertEquals(quotes, bulletJournal.getQuotes());
  }

  @Test
  public void testSetCommitmentWarnings() {
    bulletJournal.setCommitmentWarnings(4, 5);
    CommitmentWarnings commitmentWarnings = new CommitmentWarnings(4, 5);
    assertEquals(commitmentWarnings, bulletJournal.getCommitmentWarnings());
  }

  @Test
  public void testSetPersistenceWriter() {
    PersistenceWriter persistenceWriter =
        new PersistenceWriter(new ArrayList<>(), new ArrayList<>(),
            new QuotesAndNotes(""), new CommitmentWarnings(4, 4));
    bulletJournal.setPersistenceWriter();
    assertEquals(persistenceWriter, bulletJournal.getPersistenceWriter());

    BulletJournal other = new BulletJournal();
    other.addEvent(event);
    other.addTask(task);
    other.setPersistenceWriter();

    PersistenceWriter w = new PersistenceWriter(new ArrayList<>(Collections.singletonList(event)),
        new ArrayList<>(Collections.singletonList(task)), new QuotesAndNotes(""),
        new CommitmentWarnings(2, 2));
    assertEquals(w, other.getPersistenceWriter());
  }

  @Test
  public void testSetPersistenceReader() {
    bulletJournal.setPersistenceReader();
    assertEquals(new PersistenceReader(), bulletJournal.getPersistenceReader());
  }

  @Test
  public void testGetNumberOfEventsPerDay() {
    bulletJournal.addEvent(event);
    bulletJournal.addEvent(event);
    assertEquals(2, bulletJournal.getNumberOfEventsPerDay(Day.Monday));
    assertEquals(0, bulletJournal.getNumberOfEventsPerDay(Day.Friday));
  }

  @Test
  public void testGetComplete() {
    bulletJournal.addTask(task);
    Task task2 = new Task("", "", "Monday");
    task2.markAsComplete();
    bulletJournal.addTask(task2);

    assertEquals(2, bulletJournal.getNumberOfTasksPerDay(Day.Monday));
    assertEquals(1, bulletJournal.getNumberOfCompleteTasksPerDay(Day.Monday));
    assertEquals(0, bulletJournal.getNumberOfCompleteTasksPerDay(Day.Tuesday));
    assertEquals(0, bulletJournal.getNumberOfTasksPerDay(Day.Wednesday));

    assertEquals(0.5, bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Monday),
        bulletJournal.getNumberOfTasksPerDay(Day.Monday)));
  }
}