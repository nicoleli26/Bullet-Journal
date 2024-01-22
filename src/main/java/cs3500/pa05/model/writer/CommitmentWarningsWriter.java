package cs3500.pa05.model.writer;

import cs3500.pa05.model.entries.CommitmentWarnings;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Represents the Commitment Warnings Category.
 * Allows for CommitmentWarning Json entries to be
 * stored into a provided file.
 */
public class CommitmentWarningsWriter implements Writer {
  private CommitmentWarnings commitmentWarnings;

  /**
   * Constructor for the Commitment Warnings writer class
   *
   * @param commitmentWarnings the set of commitment warnings
   */
  public CommitmentWarningsWriter(CommitmentWarnings commitmentWarnings) {
    this.commitmentWarnings = commitmentWarnings;
  }

  @Override
  public void write(String path) {
    try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
      out.write(commitmentWarnings.getMaxEvents());
      out.write(commitmentWarnings.getMaxTasks());

    } catch (IOException e) {
      System.err.println("Could not save your files.");
    }
  }
}
