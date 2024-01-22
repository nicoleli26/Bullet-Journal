package cs3500.pa05.model.writer;


import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.entries.CommitmentWarnings;
import cs3500.pa05.model.entries.QuotesAndNotes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for CommitmentWarningsWriter
 */
public class CommitmentWarningsWriterTest {
  CommitmentWarningsWriter writer;

  /**
   * Setup
   */
  @BeforeEach
  public void setup() {
    writer = new CommitmentWarningsWriter(new CommitmentWarnings(4, 4));
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

  @Test
  public void testWriteToFile() throws IOException {
    PersistenceWriter writer =
        new PersistenceWriter(new ArrayList<>(), new ArrayList<>(), new QuotesAndNotes(""),
            new CommitmentWarnings(5, 5));

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    writer.write("output.txt");
    String expectedOutput = "";

    assertEquals(expectedOutput, outputStream.toString());
  }
}