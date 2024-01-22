package cs3500.pa05.model.writer;

import cs3500.pa05.model.entries.QuotesAndNotes;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Represents the writer of the Quotes and Notes.
 */
public class QuotesAndNotesWriter implements Writer {
  private final QuotesAndNotes quotesAndNotes;

  /**
   * Constructor for the QuotesAndNotesWriter
   *
   * @param quotesAndNotes the quotes and notes
   */
  public QuotesAndNotesWriter(QuotesAndNotes quotesAndNotes) {
    this.quotesAndNotes = quotesAndNotes;
  }

  /**
   * Writes quotes and notes to the file
   *
   * @param path path to the file
   */
  @Override
  public void write(String path) {
    try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
      out.write(quotesAndNotes.toString());

    } catch (IOException e) {
      System.err.println("Could not save your files.");
    }
  }
}
