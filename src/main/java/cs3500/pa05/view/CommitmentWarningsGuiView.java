package cs3500.pa05.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a Commitment Warning of CommitmentWarning View.
 */
public class CommitmentWarningsGuiView implements GuiView {

  private FXMLLoader loader;

  /**
   * Loads an instance of a Commitment Warning of CommitmentWarning View
   */
  public CommitmentWarningsGuiView() {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("CommitmentWarningError.fxml"));
  }

  /**
   * Loads the scene from the CommitmentWarning layout
   *
   * @return the layout
   */
  @Override
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
