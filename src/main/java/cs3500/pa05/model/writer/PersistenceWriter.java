package cs3500.pa05.model.writer;

import cs3500.pa05.model.entries.CommitmentWarnings;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.QuotesAndNotes;
import cs3500.pa05.model.entries.Task;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

/**
 * Represents the Persistence Category.
 * Allows for Event/Task Json entries to be
 * stored into a provided file.
 */
public class PersistenceWriter implements Writer {
  private final List<Event> events;
  private final List<Task> tasks;
  private final QuotesAndNotes quotesAndNotes;
  private final CommitmentWarnings commitmentWarnings;

  /**
   * The Persistence Writer.
   *
   * @param events             list of events
   * @param tasks              list of tasks
   * @param quotesAndNotes     the quotes and notes
   * @param commitmentWarnings the Commitment warnings
   */
  public PersistenceWriter(List<Event> events, List<Task> tasks,
                           QuotesAndNotes quotesAndNotes,
                           CommitmentWarnings commitmentWarnings) {
    this.events = events;
    this.tasks = tasks;
    this.quotesAndNotes = quotesAndNotes;
    this.commitmentWarnings = commitmentWarnings;
  }

  /**
   * When directed to write down tasks and entries within a given path,
   * first encodes each Task/Event into TaskJson/EventJson.
   * Then writes each Json entry into the given path.
   *
   * @param path the path of the desired file that would like to be written in.
   */
  public void write(String path) {
    try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
      out.write("Your Events:\n");
      for (Event event : events) {
        out.write(event.toString());
        out.write("\n");
      }
      out.write("Your Tasks:\n");
      for (Task task : tasks) {
        out.write(task.toString());
        out.write("\n");
      }
      out.write("Your Quotes and Notes: \n");
      out.write(quotesAndNotes.getDescription());
      out.write("\n");
      out.write("Your Commitment Warnings: \n");
      out.write(commitmentWarnings.getMaxTasks());
      out.write(commitmentWarnings.getMaxEvents());
    } catch (IOException e) {
      System.err.println("Could not save your files.");
    }
  }

  /**
   * retrieves the list of events.
   *
   * @return the list of events
   */
  public List<Event> getEvents() {
    return this.events;
  }

  /**
   * Retrieves the list of tasks.
   *
   * @return the list of tasks
   */
  public List<Task> getTasks() {
    return this.tasks;
  }

  /**
   * Retrieves the Quotes and Notes
   *
   * @return the quotes and notes
   */
  public QuotesAndNotes getQuotesAndNotes() {
    return this.quotesAndNotes;
  }

  /**
   * Retrieves the commitment warnings
   *
   * @return the commitment warnings.
   */
  public CommitmentWarnings getCommitmentWarnings() {
    return commitmentWarnings;
  }

  /**
   * Overrides equals
   *
   * @return true/false if the objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PersistenceWriter p)) {
      return false;
    }
    return getEvents().equals(p.getEvents())
        && getTasks().equals(p.getTasks());
  }

  /**
   * Overrides hashcode
   *
   * @return ints of hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getEvents(), getTasks());
  }
}
