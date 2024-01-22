package cs3500.pa05.view;

import cs3500.pa05.model.entries.Theme;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextFlow;

/**
 * Changes pre-defined theme based on what is inputted
 */
public class ThemeSetter {
  private Theme theme;

  /**
   * Constructor for ThemeSetter
   */
  public ThemeSetter() {
    this.theme = Theme.LIGHT;
  }

  /**
   * The current theme of the bulletJournal.
   *
   * @return the current theme.
   */
  public Theme getTheme() {
    return theme;
  }

  /**
   * @param theme inputted theme
   */
  public void setTheme(String theme) {
    if (theme.equalsIgnoreCase("light")) {
      this.theme = Theme.LIGHT;
    }
    if (theme.equalsIgnoreCase("dark")) {
      this.theme = Theme.DARK;
    }
    if (theme.equalsIgnoreCase("husky")) {
      this.theme = Theme.HUSKY;
    }
    //Light Charmonman
    //Husky Lao MN
    //Dark  Lucida Grande
  }

  /**
   * Sets the Husky theme for a list of buttons.
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void setHuskyThemeButton(List<Button> buttons) {
    for (Button button : buttons) {
      button.setTextFill(Color.BLACK);
      button.setStyle("-fx-background-color: white;");
      button.setFont(new Font("Lao MN", 13));
    }
  }

  /**
   * Sets the Light theme for a list of buttons.
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void setLightThemeButton(List<Button> buttons) {
    for (Button button : buttons) {
      button.setTextFill(Color.WHITE);
      button.setStyle("-fx-background-color: black;");
      button.setFont(new Font("Lucida Grande", 13));
    }
  }

  /**
   * Sets the Dark theme for a list of buttons.
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void setDarkThemeButton(List<Button> buttons) {
    for (Button button : buttons) {
      button.setTextFill(Color.BLACK);
      button.setStyle("-fx-background-color: white;");
      button.setFont(new Font("Lucida Grande", 13));
    }
  }

  /**
   * Sets the Husky theme for a list of labels.
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void setHuskyThemeLabel(List<Label> labels) {
    for (Label label : labels) {
      label.setTextFill(Color.BLACK);
      label.setStyle("-fx-background-color: red;");
      if (label.getFont().getSize() == 13) {
        label.setFont(Font.font("Lao MN", FontPosture.REGULAR, 13));
      } else if (label.getFont().getSize() == 17) {
        label.setFont(Font.font("Lao MN", FontPosture.REGULAR, 17));
      } else if (label.getFont().getSize() == 27) {
        label.setFont(Font.font("Lao MN", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the Light theme for a list of labels.
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void setLightThemeLabel(List<Label> labels) {
    for (Label label : labels) {
      label.setTextFill(Color.BLACK);
      label.setStyle("-fx-background-color: white;");
      if (label.getFont().getSize() == 13) {
        label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 13));
      } else if (label.getFont().getSize() == 17) {
        label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 17));
      } else if (label.getFont().getSize() == 27) {
        label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the Dark theme for a list of labels.
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void setDarkThemeLabel(List<Label> labels) {
    for (Label label : labels) {
      label.setTextFill(Color.LIGHTGRAY);
      label.setStyle("-fx-background-color: black;");
      if (label.getFont().getSize() == 13) {
        label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 13));
      } else if (label.getFont().getSize() == 17) {
        label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 17));
      } else if (label.getFont().getSize() == 27) {
        label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 27));
      }

    }
  }

  /**
   * Sets the green theme for a list of labels.
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void setGreenThemeLabel(List<Label> labels) {
    for (Label label : labels) {
      label.setTextFill(Color.BLACK);
      label.setStyle("-fx-background-color: #9eeab3;");
    }
  }

  /**
   * Sets the blue theme for a list of labels.
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void setBlueThemeLabel(List<Label> labels) {
    for (Label label : labels) {
      label.setTextFill(Color.BLACK);
      label.setStyle("-fx-background-color: #a7d9ff;");
    }
  }

  /**
   * Sets the purple theme for a list of labels.
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void setPurpleThemeLabel(List<Label> labels) {
    for (Label label : labels) {
      label.setTextFill(Color.BLACK);
      label.setStyle("-fx-background-color: #d0bafd;");
    }
  }

  /**
   * Sets the Husky theme for a list of text fields.
   *
   * @param textFields The list of text fields to apply the theme to.
   */
  public void setHuskyThemeTextField(List<TextField> textFields) {
    for (TextField textField : textFields) {
      textField.setStyle("-fx-background-color: red; -fx-text-fill: black;");
    }
  }

  /**
   * Sets the Light theme for a list of text fields.
   *
   * @param textFields The list of text fields to apply the theme to.
   */
  public void setLightThemeTextField(List<TextField> textFields) {
    for (TextField textField : textFields) {
      textField.setStyle("-fx-background-color: white; -fx-text-fill: black;");
    }
  }

  /**
   * Sets the Dark theme for a list of text fields.
   *
   * @param textFields The list of text fields to apply the theme to.
   */
  public void setDarkThemeTextField(List<TextField> textFields) {
    for (TextField textField : textFields) {
      textField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
    }
  }

  /**
   * Sets the Husky theme for a list of text areas.
   *
   * @param textAreas The list of text areas to apply the theme to.
   */
  public void setHuskyThemeTextArea(List<TextArea> textAreas) {
    for (TextArea textArea : textAreas) {
      textArea.setStyle("-fx-background-color: red; -fx-text-fill: black;");
    }
  }

  /**
   * Sets the Light theme for a list of text areas.
   *
   * @param textAreas The list of text areas to apply the theme to.
   */
  public void setLightThemeTextArea(List<TextArea> textAreas) {
    for (TextArea textArea : textAreas) {
      textArea.setStyle("-fx-background-color: white; -fx-text-fill: black;");
    }
  }

  /**
   * Sets the Dark theme for a list of text areas.
   *
   * @param textAreas The list of text areas to apply the theme to.
   */
  public void setDarkThemeTextArea(List<TextArea> textAreas) {
    for (TextArea textArea : textAreas) {
      textArea.setStyle("-fx-background-color: black; -fx-text-fill: white;");
    }
  }

  /**
   * Sets the Husky theme for a list of text flows.
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void setHuskyThemeTextFlow(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-background-color: red; -fx-text-fill: black;");
    }
  }

  /**
   * Sets the Light theme for a list of text flows.
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void setLightThemeTextFlow(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-background-color: white; -fx-text-fill: black;");
    }
  }

  /**
   * Sets the Dark theme for a list of text flows.
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void setDarkThemeTextFlow(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-background-color: black; -fx-text-fill: white;");
    }
  }


  /**
   * Sets the Label font to Bodini
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void changeLabelFontToBodoni(List<Label> labels) {
    for (Label label : labels) {
      if (label.getFont().getSize() == 13) {
        label.setFont(Font.font("Bodoni 72", FontPosture.REGULAR, 13));
      } else if (label.getFont().getSize() == 17) {
        label.setFont(Font.font("Bodoni 72", FontPosture.REGULAR, 17));
      } else if (label.getFont().getSize() == 27) {
        label.setFont(Font.font("Bodoni 72", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the Label font to Chalkduster
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void changeLabelFontToBrushScript(List<Label> labels) {
    for (Label label : labels) {
      if (label.getFont().getSize() == 13) {
        label.setFont(Font.font("Brush Script MT", FontPosture.REGULAR, 13));
      } else if (label.getFont().getSize() == 17) {
        label.setFont(Font.font("Brush Script MT", FontPosture.REGULAR, 17));
      } else if (label.getFont().getSize() == 27) {
        label.setFont(Font.font("Brush Script MT", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the Label font to Copperplate
   *
   * @param labels The list of labels to apply the theme to.
   */
  public void changeLabelFontToSongti(List<Label> labels) {
    for (Label label : labels) {
      if (label.getFont().getSize() == 13) {
        label.setFont(Font.font("Songti SC", FontPosture.REGULAR, 13));
      } else if (label.getFont().getSize() == 17) {
        label.setFont(Font.font("Songti SC", FontPosture.REGULAR, 17));
      } else if (label.getFont().getSize() == 27) {
        label.setFont(Font.font("Songti SC", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the Button Color to White
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonColorWhite(List<Button> buttons) {
    for (Button button : buttons) {
      button.setStyle("-fx-background-color: #7c7c7c;");
    }
  }

  /**
   * Sets the Button Color to Yellow
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonColorYellow(List<Button> buttons) {
    for (Button button : buttons) {
      button.setStyle("-fx-background-color: #ffd17d;");
    }
  }

  /**
   * Sets the Button Color to Red
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonColorRed(List<Button> buttons) {
    for (Button button : buttons) {
      button.setStyle("-fx-background-color: #ff5959;");
    }
  }

  /**
   * Sets the Button Text Color to Blue
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonTextColorBlue(List<Button> buttons) {
    for (Button button : buttons) {
      button.setTextFill(Color.LIGHTSKYBLUE);
    }
  }

  /**
   * Sets the Button Text Color to Black
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonTextColorBlack(List<Button> buttons) {
    for (Button button : buttons) {
      button.setTextFill(Color.BLACK);
    }
  }

  /**
   * Sets the Button Text Color to White
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonTextColorWhite(List<Button> buttons) {
    for (Button button : buttons) {
      button.setTextFill(Color.WHITE);
    }
  }

  /**
   * Sets the Button Text to Chalkduster
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonFontToBrushScript(List<Button> buttons) {
    for (Button button : buttons) {
      if (button.getFont().getSize() == 13) {
        button.setFont(Font.font("Brush Script MT", FontPosture.REGULAR, 13));
      } else if (button.getFont().getSize() == 17) {
        button.setFont(Font.font("Brush Script MT", FontPosture.REGULAR, 17));
      } else if (button.getFont().getSize() == 27) {
        button.setFont(Font.font("Brush Script MT", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the Button Text to Bondoni 72
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonFontToBodoni(List<Button> buttons) {
    for (Button button : buttons) {
      if (button.getFont().getSize() == 13) {
        button.setFont(Font.font("Bodoni 72", FontPosture.REGULAR, 13));
      } else if (button.getFont().getSize() == 17) {
        button.setFont(Font.font("Bodoni 72", FontPosture.REGULAR, 17));
      } else if (button.getFont().getSize() == 27) {
        button.setFont(Font.font("Bodoni 72", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the Button Text to Copperplate
   *
   * @param buttons The list of buttons to apply the theme to.
   */
  public void changeButtonFontToSongti(List<Button> buttons) {
    for (Button button : buttons) {
      if (button.getFont().getSize() == 13) {
        button.setFont(Font.font("Songti SC", FontPosture.REGULAR, 13));
      } else if (button.getFont().getSize() == 17) {
        button.setFont(Font.font("Songti SC", FontPosture.REGULAR, 17));
      } else if (button.getFont().getSize() == 27) {
        button.setFont(Font.font("Songti SC", FontPosture.REGULAR, 27));
      }
    }
  }

  /**
   * Sets the TextFlows blue
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void changeTextFlowColorBlue(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-background-color: #cceeff;");
    }
  }

  /**
   * Sets the TextFlows green
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void changeTextFlowColorGreen(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-background-color : #d6ffd7;");
    }
  }

  /**
   * Sets the TextFlows purple
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void changeTextFlowColorPurple(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-background-color: #eedbff;");
    }
  }

  /**
   * Sets the TextFlows black
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void changeTextFlowColorBlack(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-text-fill-color : black;");
    }
  }

  /**
   * Sets the TextFlows blue
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void changeTextFlowTextColorBlue(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-text-fill-color : blue;");
    }
  }


  /**
   * Sets the TextFlows white
   *
   * @param textFlows The list of text flows to apply the theme to.
   */
  public void changeTextFlowColorWhite(List<TextFlow> textFlows) {
    for (TextFlow textFlow : textFlows) {
      textFlow.setStyle("-fx-text-fill-color : white;");
    }
  }

}
