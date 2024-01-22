package cs3500.pa05.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a persistence reader.
 */
public class PersistenceReader {
  private final List<String> eventList;
  private final List<String> taskList;

  /**
   * Constructor for PersistenceReader.
   */
  public PersistenceReader() {
    this.eventList = new ArrayList<>();
    this.taskList = new ArrayList<>();
  }

  /**
   * When called, returns the list of events read
   *
   * @return the list of events
   */
  public List<String> getEventList() {
    return eventList;
  }

  /**
   * When called, returns the list of tasks read
   *
   * @return the list of tasks
   */
  public List<String> getTaskList() {
    return taskList;
  }

  /**
   * Reads the file and stores each Event and Task and Quote and Notes and
   * Commitment warning.
   *
   * @param path the path to the file.
   */
  public void read(String path) {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.contains("Event : ")) {
          String newLine = line.replace("Event : ", "");
          eventList.add(newLine);
        }
        if (line.contains("Task : ")) {
          String newLine = line.replace("Task : ", "");
          taskList.add(newLine);
        }
      }
    } catch (IOException e) {
      System.err.println("Cannot read your file");
    }
  }

  /**
   * Overrides equals
   *
   * @param o the object being compared
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PersistenceReader r)) {
      return false;
    }
    return eventList.equals(r.eventList) && eventList.equals(r.eventList);
  }
}