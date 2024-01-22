package cs3500.pa05.view;

import cs3500.pa05.controller.BulletJournalController;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Represents a Week of a BulletJournal View.
 */
public class WeekGuiView implements GuiView {
  private FXMLLoader loader;

  /**
   * Loads an instance of a WeekView for a BulletJournal
   *
   * @param controller the current controller of the View.
   */
  public WeekGuiView(BulletJournalController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("weekview.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads the scene from the simple Whack-a-Mole GUI layout.
   *
   * @return the layout
   */
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
