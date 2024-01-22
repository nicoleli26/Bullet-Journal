package cs3500.pa05.model;


import cs3500.pa05.model.entries.CommitmentWarnings;
import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.DayCell;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.QuotesAndNotes;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.writer.PersistenceWriter;
import cs3500.pa05.model.writer.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the entire bulletJournal
 */
public class BulletJournal {
  private final DayCell[] days;
  private QuotesAndNotes quotesAndNotes;
  private CommitmentWarnings commitmentWarnings;
  private Writer persistenceWriter;
  private PersistenceReader persistenceReader;

  /**
   * Constructor for a bullet journal.
   */
  public BulletJournal() {
    this.days = new DayCell[7];
    setDays();
  }

  /**
   * Retrieves the notes and quotes of the Bullet Journal
   *
   * @return the notes and quotes.
   */
  public QuotesAndNotes getQuotes() {
    return quotesAndNotes;
  }

  /**
   * Retrieves the Persistence writer of the BulletJournal.
   *
   * @return the persistence writer
   */
  public Writer getPersistenceWriter() {
    return persistenceWriter;
  }

  /**
   * Retrieves the PersistenceReader
   *
   * @return the persistence reader
   */
  public PersistenceReader getPersistenceReader() {
    return persistenceReader;
  }

  /**
   * Returns the commitment warnings of the bulletjournal
   *
   * @return the commitment warnings
   */
  public CommitmentWarnings getCommitmentWarnings() {
    return commitmentWarnings;
  }

  /**
   * Returns the DayCells of a bullet journal
   *
   * @return the day cells
   */
  public DayCell[] getDayCell() {
    return days;
  }

  /**
   * Sets the days of a week with the day's respective list of events/tasks
   */
  private void setDays() {
    DayCell daySunday = new DayCell();
    daySunday.setDay(Day.Sunday);
    DayCell dayMonday = new DayCell();
    dayMonday.setDay(Day.Monday);
    DayCell dayTuesday = new DayCell();
    dayTuesday.setDay(Day.Tuesday);
    DayCell dayWednesday = new DayCell();
    dayWednesday.setDay(Day.Wednesday);
    DayCell dayThursday = new DayCell();
    dayThursday.setDay(Day.Thursday);
    DayCell dayFriday = new DayCell();
    dayFriday.setDay(Day.Friday);
    DayCell daySaturday = new DayCell();
    daySaturday.setDay(Day.Saturday);
    days[0] = daySunday;
    days[1] = dayMonday;
    days[2] = dayTuesday;
    days[3] = dayWednesday;
    days[4] = dayThursday;
    days[5] = dayFriday;
    days[6] = daySaturday;
  }

  /**
   * When a user wants to create a new event, adds the given event into
   * the DayCell correlating to the events provided Day.
   *
   * @param e the event that will be added.
   */
  public void addEvent(Event e) {
    for (DayCell dayCell : days) {
      if (e.getDay().equals(dayCell.getDay())) {
        dayCell.addEvent(e);
      }
    }
  }

  /**
   * When a user wants to create a new task, adds the given task into
   * the DayCell correlating to the tasks provided Day.
   *
   * @param t the task that will be added.
   */
  public void addTask(Task t) {
    for (DayCell dayCell : days) {
      if (t.getDay().equals(dayCell.getDay())) {
        dayCell.addTask(t);
      }
    }
  }

  /**
   * Sets the QuotesAndNotes field of a BulletJournal
   *
   * @param s the provided description of a bulletjournal.
   */
  public void setQuotesAndNotes(String s) {
    this.quotesAndNotes = new QuotesAndNotes(s);
  }

  /**
   * Sets the Persistence Reader
   */
  public void setPersistenceReader() {
    this.persistenceReader = new PersistenceReader();
  }

  /**
   * @param maxTasks  maximum tasks
   * @param maxEvents maximum events
   */
  public void setCommitmentWarnings(int maxTasks, int maxEvents) {
    this.commitmentWarnings = new CommitmentWarnings(maxTasks, maxEvents);
  }

  /**
   * Adds events and tasks to persistence writer
   */
  public void setPersistenceWriter() {
    List<Event> events = new ArrayList<>();
    List<Task> tasks = new ArrayList<>();

    for (DayCell dayCell : days) {
      for (Event event : dayCell.getEvents()) {
        events.add(event);
      }
    }
    for (DayCell dayCell : days) {
      for (Task task : dayCell.getTasks()) {
        tasks.add(task);
      }
    }
    this.persistenceWriter = new PersistenceWriter(events, tasks,
        this.quotesAndNotes, this.commitmentWarnings);
  }


  /**
   * Gets the entire list of Tasks within a bullet journal.
   *
   * @return a list of all tasks
   */
  public List<Task> getAllTasks() {
    List<Task> totalTasks = new ArrayList<>();
    for (DayCell dayCell : days) {
      for (Task task : dayCell.getTasks()) {
        totalTasks.add(task);
      }
    }
    return totalTasks;
  }

  /**
   * Gets the entire list of Events within a bulletjournal.
   *
   * @return a list of all events.
   */
  public List<Event> getAllEvents() {
    List<Event> totalEvents = new ArrayList<>();
    for (DayCell dayCell : days) {
      for (Event event : dayCell.getEvents()) {
        totalEvents.add(event);
      }
    }
    return totalEvents;
  }

  /**
   * Gets the total number of Events of a given day.
   *
   * @param day the given day
   * @return the number of events within that day
   */
  public int getNumberOfEventsPerDay(Day day) {
    int count = 0;
    for (DayCell dayCell : days) {
      for (Event event : dayCell.getEvents()) {
        if (event.getDay().equals(day)) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Gets the total number of Tasks of a given day.
   *
   * @param day the given day
   * @return the number of tasks within that day
   */
  public int getNumberOfTasksPerDay(Day day) {
    int count = 0;
    for (DayCell dayCell : days) {
      for (Task task : dayCell.getTasks()) {
        if (task.getDay().equals(day)) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Gets the number of all completed tasks
   *
   * @return the number of all completed tasks.
   */
  public int getNumberOfCompleteTasks() {
    List<Task> completed = new ArrayList<>();
    for (DayCell dayCell : days) {
      for (Task task : dayCell.getTasks()) {
        if (task.getIsComplete()) {
          completed.add(task);
        }
      }
    }
    return completed.size();
  }

  /**
   * Represents the ratio of Completed Tasks to total Tasks
   *
   * @param complete the number of completed tasks
   * @param total    the number of total tasks
   * @return completed tasks / total tasks
   */
  public double getCompleteToIncomplete(int complete, int total) {
    return (double) complete / (double) total;
  }

  /**
   * Gets the number of completed tasks in a bullet journal.
   *
   * @param day the given day
   * @return the number of completed tasks.
   */
  public int getNumberOfCompleteTasksPerDay(Day day) {
    int count = 0;
    for (DayCell dayCell : days) {
      for (Task task : dayCell.getTasks()) {
        if (task.getIsComplete() && task.getDay().equals(day)) {
          count++;
        }
      }
    }
    return count;
  }
}

