package cs3500.pa05;

import cs3500.pa05.controller.BulletJournalController;
import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.view.WeekGuiView;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The entry point to the program.
 */
public class Driver extends Application {

  /**
   * Starts the program
   */
  @Override
  public void start(Stage stage) throws IOException {
    BulletJournal bulletJournal = new BulletJournal();
    BulletJournalController controller = new BulletJournalController(bulletJournal, stage);
    WeekGuiView view = new WeekGuiView(controller);
    try {
      stage.setScene(view.load());
      controller.run();
      stage.show();
      stage.setTitle("Week View");
    } catch (IllegalStateException e) {
      System.err.println("Unable to load GUI.");
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
