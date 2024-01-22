package cs3500.pa05.model.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.entries.QuotesAndNotes;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuotesAndNotesWriterTest {
  QuotesAndNotesWriter writer;

  @BeforeEach
  void setUp() {
    writer = new QuotesAndNotesWriter(new QuotesAndNotes(""));
  }

  @Test
  void write() {
  }

  @Test
  public void testException() {
    String invalidPath = "";

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setErr(new PrintStream(outputStream));

    writer.write(invalidPath);

    String errorMessage = "Could not save your files.\n";
    assertEquals(errorMessage, outputStream.toString());
  }
}