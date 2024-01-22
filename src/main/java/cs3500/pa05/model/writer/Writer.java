package cs3500.pa05.model.writer;

import cs3500.pa05.model.entries.Task;

/**
 * Represents the act of saving all data entries to a file.
 */
public interface Writer {

  /**
   * Writes the given data into a provided path name.
   *
   * @param path the String format of the desired file.
   */
  void write(String path);

}
