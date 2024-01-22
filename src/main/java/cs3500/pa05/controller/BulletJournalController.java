package cs3500.pa05.controller;


import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.PersistenceReader;
import cs3500.pa05.model.entries.Day;
import cs3500.pa05.model.entries.DayCell;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.entries.Time;
import cs3500.pa05.model.writer.Writer;
import cs3500.pa05.view.ThemeSetter;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Represents the Controller for a Bullet Journal
 */
public class BulletJournalController {

  private BulletJournal bulletJournal;
  private Stage stage;

  @FXML
  private AnchorPane anchor;
  @FXML
  private Scene sceneName;
  //Any buttons/texts pertaining to EVENT
  @FXML
  private Button addEvent;
  @FXML
  private TextField eventName;
  @FXML
  private TextField eventDescription;
  @FXML
  private TextField eventDay;
  @FXML
  private TextField eventTimeHour;
  @FXML
  private TextField eventTimeMinute;
  @FXML
  private TextField eventTimeZone;
  @FXML
  private TextField eventDuration;

  //Any buttons/texts pertaining to TASK
  @FXML
  private Button addTask;
  @FXML
  private TextField taskName;
  @FXML
  private TextField taskDescription;
  @FXML
  private TextField taskDay;
  @FXML
  private TextFlow taskQueue;
  @FXML
  private Button refreshTaskQueue;
  @FXML
  private HBox urlBox;

  //CLOSE BUTTONS
  @FXML
  private Button closeEvent;
  @FXML
  private Button closeTask;

  //SAVE BUTTONS
  @FXML
  private Button saveTask;
  @FXML
  private Button saveEvent;

  //Pop ups
  @FXML
  private Popup popupEvent;
  @FXML
  private Popup popupTask;

  //Quotes and Notes
  @FXML
  private TextArea quotesAndNotes;
  @FXML
  private Button saveQuotesAndNotes;

  //CommitmentWarnings
  @FXML
  private Button commitmentWarnings;
  @FXML
  private TextField maxTasks;
  @FXML
  private TextField maxEvents;
  @FXML
  private Button saveCommits;
  @FXML
  private Button closeCommits;
  @FXML
  private Popup commitPopup;

  //Writing events
  @FXML
  private TextFlow sundayEvents;
  @FXML
  private TextFlow mondayEvents;
  @FXML
  private TextFlow tuesdayEvents;
  @FXML
  private TextFlow wednesdayEvents;
  @FXML
  private TextFlow thursdayEvents;
  @FXML
  private TextFlow fridayEvents;
  @FXML
  private TextFlow saturdayEvents;

  //Writing Tasks
  @FXML
  private VBox sundayTasks;
  @FXML
  private VBox mondayTasks;
  @FXML
  private VBox tuesdayTasks;
  @FXML
  private VBox wednesdayTasks;
  @FXML
  private VBox thursdayTasks;
  @FXML
  private VBox fridayTasks;
  @FXML
  private VBox saturdayTasks;

  //Saving into .Bujo
  @FXML
  private Button saveAll;
  @FXML
  private Button saveMyBullet;
  @FXML
  private Button openMyBullet;
  @FXML
  private Popup saveFilePopup;
  @FXML
  private Button closeSaveToBujo;

  //WeeklyOverview
  @FXML
  private Button weeklyOverview;
  @FXML
  private Button closeWeeklyOverview;
  @FXML
  private Popup weeklyOverviewPopup;
  @FXML
  private BarChart<String, Number> numberOfEventsPerDay;
  @FXML
  private BarChart<String, Number> numberOfTasksPerDay;
  @FXML
  private PieChart percentOfTasksCompleted;
  @FXML
  private Button refresh;

  //Changing the Theme buttons
  @FXML
  private Button huskyTheme;
  @FXML
  private Button lightTheme;
  @FXML
  private Button darkTheme;
  @FXML
  private ChoiceBox backgroundChoiceBox;
  private ObservableList<String> backgroundColor = FXCollections.observableArrayList(
      "Blue", "Green", "Purple");
  @FXML
  private ChoiceBox fontChoiceBox;
  private ObservableList<String> fontStyle = FXCollections.observableArrayList(
      "Bodoni 72", "Brush Script MT", "Songti SC");
  @FXML
  private ChoiceBox buttonChoiceBox;
  private ObservableList<String> buttonColor = FXCollections.observableArrayList(
      "Light gray", "Light yellow", "Light red");
  @FXML
  private ChoiceBox textColorChoiceBox;
  private ObservableList<String> textColor = FXCollections.observableArrayList(
      "Black", "White", "Blue");

  //WeekView day labels
  @FXML
  private Label sundayDay;
  @FXML
  private Label mondayDay;
  @FXML
  private Label tuesdayDay;
  @FXML
  private Label wednesdayDay;
  @FXML
  private Label thursdayDay;
  @FXML
  private Label fridayDay;
  @FXML
  private Label saturdayDay;

  //WeekView Day Task Labels
  @FXML
  private Label sundayTasksLabel;
  @FXML
  private Label mondayTasksLabel;
  @FXML
  private Label tuesdayTasksLabel;
  @FXML
  private Label wednesdayTaskLabel;
  @FXML
  private Label thursdayTaskLabel;
  @FXML
  private Label fridayTasksLabel;
  @FXML
  private Label saturdayTasksLabel;

  //Week view event labels
  @FXML
  private Label sundayEventLabel;
  @FXML
  private Label mondayEventsLabel;
  @FXML
  private Label tuesdayEventsLabel;
  @FXML
  private Label wednesdayEventsLabel;
  @FXML
  private Label thursdayEventsLabel;
  @FXML
  private Label fridayEventsLabel;
  @FXML
  private Label saturdayEventsLabel;
  @FXML
  private Label quotesAndNotesLabel;
  @FXML
  private Label taskQueueLabel;
  @FXML
  private Label urlLabel;
  @FXML
  private Label buttonsLabel;
  @FXML
  private Label textColorLabel;
  @FXML
  private Label backgroundLabel;
  @FXML
  private Label fontLabel;
  @FXML
  private Label chooseThemeLabel;

  //Progress bar
  @FXML
  private Button refreshProgressBars;
  @FXML
  private ProgressBar sundayProgressBar;
  @FXML
  private ProgressBar mondayProgressBar;
  @FXML
  private ProgressBar tuesdayProgressBar;
  @FXML
  private ProgressBar wednesdayProgressBar;
  @FXML
  private ProgressBar thursdayProgressBar;
  @FXML
  private ProgressBar fridayProgressBar;
  @FXML
  private ProgressBar saturdayProgressBar;


  ThemeSetter themeSetter = new ThemeSetter();
  private static final List<Button> buttonList = new ArrayList<>();
  private final List<Label> labelList = new ArrayList<>();
  private final List<TextField> textFieldList = new ArrayList<>();
  private final List<TextFlow> textFlowList = new ArrayList<>();
  private final List<TextArea> textAreaList = new ArrayList<>();
  private final List<ChoiceBox> choiceboxList = new ArrayList<>();

  private Scene scene;


  /**
   * Initiates the BulletJournal.
   *
   * @param bulletJournal a single bulletJournal
   * @param stage         the stage
   */
  public BulletJournalController(BulletJournal bulletJournal, Stage stage) {
    this.bulletJournal = bulletJournal;
    this.stage = stage;
  }

  /**
   * Generates any bullet journal methods that will help generate any bullet journal changes
   * to the GUI view of the journal
   *
   * @throws IOException if unable to run
   */
  @FXML
  public void run() throws IOException {
    //adds a event
    addEvent();
    //adds a task
    addTask();
    //adds quotes
    addQuotesAndNotes();
    //adds commits
    addCommitmentWarnings();
    //saves all entries
    saveAllEntries();
    //See weekly overview
    seeWeeklyOverview();
    //refresh task queue
    setRefreshTaskQueue();
    //refresh progress bar
    refreshProgressBar();

    addButtonsToList();
    addTextAreasToList();
    addTextFlowToList();
    addTextFieldToList();
    addLabelsToList();
    addChoiceBoxToList();
    //tests color change
    changeThemeInGui();
    // initialized choice boxes
    initializeBackgroundChoiceBox();
    initializeFontChoiceBox();
    initializeButtonChoiceBox();
    initializeTextColorChoiceBox();
    // custom theme
    changeBackgroundInGui();
    changeFontInGui();
    changeButtonColorInGui();
    changeTextColorsInGui();
  }

  /**
   * When user clicks on refresh progress, sets an action on it.
   */
  @FXML
  public void refreshProgressBar() {
    refreshProgressBars.setOnAction(e -> updateProgressBars());
  }

  /**
   * When a user clicks on refresh, updates all aspects of the progress bars with
   * current information in the bullet journal
   */
  @FXML
  private void updateProgressBars() {
    sundayProgressBar.setProgress(bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Sunday),
        bulletJournal.getNumberOfTasksPerDay(Day.Sunday)));
    mondayProgressBar.setProgress(bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Monday),
        bulletJournal.getNumberOfTasksPerDay(Day.Monday)));
    tuesdayProgressBar.setProgress(bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Tuesday),
        bulletJournal.getNumberOfTasksPerDay(Day.Tuesday)));
    wednesdayProgressBar.setProgress(bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Wednesday),
        bulletJournal.getNumberOfTasksPerDay(Day.Wednesday)));
    thursdayProgressBar.setProgress(bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Thursday),
        bulletJournal.getNumberOfTasksPerDay(Day.Thursday)));
    fridayProgressBar.setProgress(bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Friday),
        bulletJournal.getNumberOfTasksPerDay(Day.Friday)));
    saturdayProgressBar.setProgress(bulletJournal.getCompleteToIncomplete(
        bulletJournal.getNumberOfCompleteTasksPerDay(Day.Saturday),
        bulletJournal.getNumberOfTasksPerDay(Day.Saturday)));
  }

  /**
   * When a user has made changes to their Tasks and then a user hits refresh,
   * converts
   */
  @FXML
  public void setRefreshTaskQueue() {
    refreshTaskQueue.setOnAction(e -> addToTaskQueue());
  }

  /**
   * When a user clicks the "refresh" button,
   * writes in the updated version of each task within a
   * bullet journal.
   */
  @FXML
  private void addToTaskQueue() {
    //removes all entries that are already within the text flow.
    taskQueue.getChildren().clear();

    for (DayCell dayCell : bulletJournal.getDayCell()) {
      for (Task task : dayCell.getTasks()) {
        Text text = new Text(task.getName() + " " + task.getIsComplete() + "\n");
        taskQueue.getChildren().add(text);
      }
    }
  }

  /**
   * @throws IOException if scene does not load
   */
  @FXML
  public void seeWeeklyOverview() throws IOException {
    weeklyOverview.setOnAction(e -> makeWeeklyPopup());
    //opens the pop up
    this.weeklyOverviewPopup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
        .getResource("weeklyoverview.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    weeklyOverviewPopup.getContent().add((Node) s.getRoot());

    refresh.setOnAction(e -> initiateDemographics());

    //closes the popup
    closeWeeklyOverview.setOnAction(e -> weeklyOverviewPopup.hide());
    weeklyOverviewPopup.getContent().add(closeWeeklyOverview);
  }

  /**
   * Initiates all information in bulletjournal to showcase all weekly overview
   * numbers.
   */
  @FXML
  private void initiateDemographics() {
    numberOfEventsPerDay.setTitle("Number of Events per Day");
    numberOfEventsPerDay.getData().clear(); //when a user press refresh, erase current data.
    XYChart.Series<String, Number> seriesEvents = new XYChart.Series<>();
    //initializes data entry in BarChartEvent
    seriesEvents.getData()
        .add(new XYChart.Data<>("Sunday", bulletJournal.getNumberOfEventsPerDay(Day.Sunday)));
    seriesEvents.getData()
        .add(new XYChart.Data<>("Monday", bulletJournal.getNumberOfEventsPerDay(Day.Monday)));
    seriesEvents.getData()
        .add(new XYChart.Data<>("Tuesday", bulletJournal.getNumberOfEventsPerDay(Day.Tuesday)));
    seriesEvents.getData()
        .add(new XYChart.Data<>("Wednesday", bulletJournal.getNumberOfEventsPerDay(Day.Wednesday)));
    seriesEvents.getData()
        .add(new XYChart.Data<>("Thursday", bulletJournal.getNumberOfEventsPerDay(Day.Thursday)));
    seriesEvents.getData()
        .add(new XYChart.Data<>("Friday", bulletJournal.getNumberOfEventsPerDay(Day.Friday)));
    seriesEvents.getData()
        .add(new XYChart.Data<>("Saturday", bulletJournal.getNumberOfEventsPerDay(Day.Saturday)));
    numberOfEventsPerDay.getData().add(seriesEvents);

    //initializes data entry in BarChartTasks
    numberOfTasksPerDay.setTitle("Number of Tasks per Day");
    numberOfTasksPerDay.getData().clear(); //when a user press refresh, erase current data.
    XYChart.Series<String, Number> seriesTasks = new XYChart.Series<>();
    seriesTasks.getData()
        .add(new XYChart.Data<>("Sunday", bulletJournal.getNumberOfTasksPerDay(Day.Sunday)));
    seriesTasks.getData()
        .add(new XYChart.Data<>("Monday", bulletJournal.getNumberOfTasksPerDay(Day.Monday)));
    seriesTasks.getData()
        .add(new XYChart.Data<>("Tuesday", bulletJournal.getNumberOfTasksPerDay(Day.Tuesday)));
    seriesTasks.getData()
        .add(new XYChart.Data<>("Wednesday", bulletJournal.getNumberOfTasksPerDay(Day.Wednesday)));
    seriesTasks.getData()
        .add(new XYChart.Data<>("Thursday", bulletJournal.getNumberOfTasksPerDay(Day.Thursday)));
    seriesTasks.getData()
        .add(new XYChart.Data<>("Friday", bulletJournal.getNumberOfTasksPerDay(Day.Friday)));
    seriesTasks.getData()
        .add(new XYChart.Data<>("Saturday", bulletJournal.getNumberOfTasksPerDay(Day.Saturday)));
    numberOfTasksPerDay.getData().add(seriesTasks);

    percentOfTasksCompleted.setTitle("Percent of Tasks Completed");

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Number of Completed Tasks", bulletJournal.getNumberOfCompleteTasks()),
        new PieChart.Data("Number of Total Tasks", bulletJournal.getAllTasks().size()));
    percentOfTasksCompleted.setData(pieChartData);

  }

  /**
   * Shows the weekly overview popup
   */
  @FXML
  private void makeWeeklyPopup() {
    this.weeklyOverviewPopup.show(this.stage);
  }

  /**
   * Saves
   *
   * @throws IOException if unable to load
   */
  @FXML
  public void saveAllEntries() throws IOException {
    //opens the pop up
    saveAll.setOnAction(e -> makeSavePopup());
    this.saveFilePopup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("saveToBujo.fxml"));
    loader.setController(this);
    scene = loader.load();
    saveFilePopup.getContent().add((Node) scene.getRoot());

    //When user clicks save my bullet, saves any Events, Tasks, and Quotes&Notes
    //TODO add commitment warnings
    saveMyBullet.setOnAction(e -> saveToMyBullet());

    //TODO when clicks button, opens the picked file
    openMyBullet.setOnAction(e -> openToMyBullet());

    //Closes the popup
    closeSaveToBujo.setOnAction(e -> saveFilePopup.hide());
    saveFilePopup.getContent().add(closeSaveToBujo);
  }

  /**
   * Opens any Tasks and Events that are stored within a .bujo file.
   */
  @FXML
  private void openToMyBullet() {
    bulletJournal.setPersistenceReader();
    PersistenceReader reader = bulletJournal.getPersistenceReader();
    reader.read("example.bujo");
    List<String> events = reader.getEventList();
    for (String event : events) {
      String newEvent = event.toLowerCase();
      if (newEvent.contains("sunday")) {
        Text text = new Text(newEvent);
        sundayEvents.getChildren().add(text);
      }
      if (newEvent.contains("monday")) {
        Text text = new Text(newEvent);
        mondayEvents.getChildren().add(text);
      }
      if (newEvent.contains("tuesday")) {
        Text text = new Text(newEvent);
        tuesdayEvents.getChildren().add(text);
      }
      if (newEvent.contains("wednesday")) {
        Text text = new Text(newEvent);
        wednesdayEvents.getChildren().add(text);
      }
      if (newEvent.contains("thursday")) {
        Text text = new Text(newEvent);
        thursdayEvents.getChildren().add(text);
      }
      if (newEvent.contains("friday")) {
        Text text = new Text(newEvent);
        fridayEvents.getChildren().add(text);
      }
      if (newEvent.contains("saturday")) {
        Text text = new Text(newEvent);
        saturdayEvents.getChildren().add(text);
      }
    }

    List<String> taskList = reader.getTaskList();
    for (String task : taskList) {
      String newTask = task.toLowerCase();
      if (task.contains("sunday")) {
        Button button = new Button(task);
        sundayTasks.getChildren().add(button);
      }
      if (task.contains("monday")) {
        Button button = new Button(task);
        mondayTasks.getChildren().add(button);
      }
      if (task.contains("tuesday")) {
        Button button = new Button(task);
        tuesdayTasks.getChildren().add(button);
      }
      if (task.contains("wednesday")) {
        Button button = new Button(task);
        wednesdayTasks.getChildren().add(button);
      }
      if (task.contains("thursday")) {
        Button button = new Button(task);
        thursdayTasks.getChildren().add(button);
      }
      if (task.contains("friday")) {
        Button button = new Button(task);
        fridayTasks.getChildren().add(button);
      }
      if (task.contains("saturday")) {
        Button button = new Button(task);
        saturdayTasks.getChildren().add(button);
      }
    }
  }

  /**
   * Saves contents to bujo file
   */
  @FXML
  private void saveToMyBullet() {
    bulletJournal.setPersistenceWriter();
    Writer persistenceWriter = bulletJournal.getPersistenceWriter();
    persistenceWriter.write("example.bujo");
  }

  /**
   * Shows save file popup
   */
  @FXML
  private void makeSavePopup() {
    this.saveFilePopup.show(this.stage);
  }

  /**
   * @throws IOException if unable to load
   */
  @FXML
  public void addCommitmentWarnings() throws IOException {
    //opens the pop up
    commitmentWarnings.setOnAction(e -> makeCommitPopup());
    this.commitPopup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
        .getResource("commitmentwarnings.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    commitPopup.getContent().add((Node) s.getRoot());

    saveCommits.setOnAction(e -> createCommit());

    //Closes the popup
    closeCommits.setOnAction(e -> commitPopup.hide());
    commitPopup.getContent().add(closeCommits);
  }

  /**
   * Displays the pop up for a Commit warning
   */
  @FXML
  private void makeCommitPopup() {
    this.commitPopup.show(this.stage);
  }

  /**
   * When a user wants to create a commit, creates a commit from text fields.
   */
  @FXML
  private void createCommit() {
    String textMaxTasks = maxTasks.getText();
    String textMaxEvents = maxEvents.getText();
    int maxTasks = Integer.parseInt(textMaxTasks);
    int maxEvents = Integer.parseInt(textMaxEvents);
    bulletJournal.setCommitmentWarnings(maxTasks, maxEvents);
  }

  /**
   * When addEvent button is clicked, brings up a pop-up that takes in the information
   * of a new event.
   * Once the user clicks saveEvent,this information is then sent to a helper method createEvent()
   * where any items put within the text box are converted to an event and then stored.
   *
   * @throws IOException if unable to load
   */
  @FXML
  public void addEvent() throws IOException {
    addEvent.setOnAction(e -> makeEventPopup());
    this.popupEvent = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("popupevent.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popupEvent.getContent().add((Node) s.getRoot());

    saveEvent.setOnAction(e -> createEvent());

    //Closes the popup
    closeEvent.setOnAction(e -> popupEvent.hide());
    popupEvent.getContent().add(closeEvent);
  }

  /**
   * Creates an event popup
   */
  @FXML
  private void makeEventPopup() {
    this.popupEvent.show(this.stage);
  }

  /**
   * Any information present within a text field when a user clicks
   * 'Save' is then converted into an Event and then stored in a BulletJournal.
   * If the description of an Event contains a hyper-link, parses the provided String-URL
   * and parses into a URL which will be linked to a hyper-link.
   * The hyper-link, when clicked, will open the link in a browser.
   */
  @FXML
  private void createEvent() {
    String name = eventName.getText();
    String description = eventDescription.getText();
    String day = eventDay.getText();
    String timeHour = eventTimeHour.getText();
    String timeMinutes = eventTimeMinute.getText();
    String timeZone = eventTimeZone.getText();
    String textDuration = eventDuration.getText();

    Time time = new Time(timeHour, timeMinutes, timeZone);
    double duration = Double.parseDouble(textDuration);

    Event event = new Event(name, description, day, time, duration);
    bulletJournal.addEvent(event);


    addEventToWeek(event);

    //determines if an Event has a hyperlink
    if (description.contains("http") || description.contains("https")) {
      Hyperlink hyperlink = new Hyperlink("Open " + name + " " + description);
      urlBox.getChildren().add(hyperlink);
      hyperlink.setOnAction(e -> openLinkInBrowser(description));
    }


    eventName.clear();
    eventDescription.clear();
    eventDay.clear();
    eventTimeHour.clear();
    eventTimeMinute.clear();
    eventTimeZone.clear();
    eventDuration.clear();
  }

  /**
   * Correlates each day entry to each Event Day cell.
   *
   * @param e the given event that will be stored in its respective Day.
   */
  @FXML
  private void addEventToWeek(Event e) {

    if (e.getDay().equals(Day.Sunday)) {
      Text text = new Text(e.toString());
      sundayEvents.getChildren().add(text);
    }
    if (e.getDay().equals(Day.Monday)) {
      Text text = new Text(e.toString());
      mondayEvents.getChildren().add(text);
    }
    if (e.getDay().equals(Day.Tuesday)) {
      Text text = new Text(e.toString());
      tuesdayEvents.getChildren().add(text);
    }
    if (e.getDay().equals(Day.Wednesday)) {
      Text text = new Text(e.toString());
      wednesdayEvents.getChildren().add(text);
    }
    if (e.getDay().equals(Day.Thursday)) {
      Text text = new Text(e.toString());
      thursdayEvents.getChildren().add(text);
    }
    if (e.getDay().equals(Day.Friday)) {
      Text text = new Text(e.toString());
      fridayEvents.getChildren().add(text);
    }
    if (e.getDay().equals(Day.Saturday)) {
      Text text = new Text(e.toString());
      saturdayEvents.getChildren().add(text);
    }
  }

  /**
   * Adds a task into a bulletJournal.
   * Loads a pop up that has parameters that accepts entries that create a Task.
   *
   * @throws IOException if unable to load the popup.
   */
  @FXML
  public void addTask() throws IOException {
    addTask.setOnAction(e -> makeTaskPopup());
    this.popupTask = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("popuptask.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popupTask.getContent().add((Node) s.getRoot());

    saveTask.setOnAction(e -> createTask());

    //Closes the pop-up
    closeTask.setOnAction(e -> popupTask.hide());
    popupTask.getContent().add(closeTask);
  }

  /**
   * When a Task is created, adds the Task into the bulletJournal.
   * If the Task description contains a link, stores a hyperlink into
   * the HyperLink description.
   * Adds all tasks into the
   */
  @FXML
  private void createTask() {
    //Extracts the tasks parameters
    String name = taskName.getText();
    String description = taskDescription.getText();
    String day = taskDay.getText();
    Task task = new Task(name, description, day);

    bulletJournal.addTask(task);

    //Adds a task into the week.
    addTaskToWeek(task);

    //determines if Task has a hyperlink
    if (description.contains("http") || description.contains("https")) {
      Hyperlink hyperlink = new Hyperlink("Open " + name + " " + description);
      urlBox.getChildren().add(hyperlink);
      hyperlink.setOnAction(e -> openLinkInBrowser(description));
    }

    taskName.clear();
    taskDescription.clear();
    taskDay.clear();
  }

  /**
   * When provided a URl link, opens the link in the user's browser.
   *
   * @param url the desired URL to open.
   */
  private void openLinkInBrowser(String url) {
    try {
      Desktop desktop = Desktop.getDesktop();
      if (desktop.isSupported(Desktop.Action.BROWSE)) {
        URI uri = new URI(url);
        desktop.browse(uri);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  /**
   * When a new task is created, creates a task button that when clicked,
   * marks the task as complete.
   *
   * @param t the desired task to be added.
   */
  @FXML
  private void addTaskToWeek(Task t) {
    if (t.getDay().equals(Day.Sunday)) {
      Button button = new Button(t.getName());
      sundayTasks.getChildren().add(button);
      button.setOnAction(e -> t.markAsComplete());
    }
    if (t.getDay().equals(Day.Monday)) {
      Button button = new Button(t.getName());
      mondayTasks.getChildren().add(button);
      button.setOnAction(e -> t.markAsComplete());
    }
    if (t.getDay().equals(Day.Tuesday)) {
      Button button = new Button(t.getName());
      tuesdayTasks.getChildren().add(button);
      button.setOnAction(e -> t.markAsComplete());
    }
    if (t.getDay().equals(Day.Wednesday)) {
      Button button = new Button(t.getName());
      wednesdayTasks.getChildren().add(button);
      button.setOnAction(e -> t.markAsComplete());
    }
    if (t.getDay().equals(Day.Thursday)) {
      Button button = new Button(t.getName());
      thursdayTasks.getChildren().add(button);
      button.setOnAction(e -> t.markAsComplete());
    }
    if (t.getDay().equals(Day.Friday)) {
      Button button = new Button(t.getName());
      fridayTasks.getChildren().add(button);
      button.setOnAction(e -> t.markAsComplete());
    }
    if (t.getDay().equals(Day.Saturday)) {
      Button button = new Button(t.getName());
      saturdayTasks.getChildren().add(button);
      button.setOnAction(e -> t.markAsComplete());
    }
  }

  /**
   * Creates a task popup
   */
  @FXML
  private void makeTaskPopup() {
    this.popupTask.show(this.stage);
  }

  /**
   * When a user enters anything in the quotes and notes section,
   * and then clicks save, stores the quotes and notes into the bullet journal.
   */
  @FXML
  public void addQuotesAndNotes() {
    saveQuotesAndNotes.setOnAction(e -> createNotesAndQuotes());
  }

  /**
   * Takes any string input in the quotes and notes section, and then
   * stores the quotes and notes into the bulletJournal
   */
  @FXML
  private void createNotesAndQuotes() {
    String quotes = quotesAndNotes.getText();
    bulletJournal.setQuotesAndNotes(quotes);
  }

  /**
   * Adds the buttons to the buttonList.
   */
  private void addButtonsToList() {
    buttonList.add(addEvent);
    buttonList.add(addTask);
    buttonList.add(closeEvent);
    buttonList.add(closeTask);
    buttonList.add(saveTask);
    buttonList.add(saveEvent);
    buttonList.add(saveQuotesAndNotes);
    buttonList.add(commitmentWarnings);
    buttonList.add(saveCommits);
    buttonList.add(closeCommits);
    buttonList.add(saveTask);
    buttonList.add(saveAll);
    buttonList.add(saveMyBullet);
    buttonList.add(openMyBullet);
    buttonList.add(weeklyOverview);
    buttonList.add(closeWeeklyOverview);
    buttonList.add(huskyTheme);
    buttonList.add(lightTheme);
    buttonList.add(darkTheme);
    buttonList.add(refreshTaskQueue);
    buttonList.add(refreshProgressBars);
  }

  /**
   * Adds the labels to the labelList.
   */
  private void addLabelsToList() {
    labelList.add(taskQueueLabel);
    labelList.add(quotesAndNotesLabel);
    labelList.add(sundayEventLabel);
    labelList.add(mondayEventsLabel);
    labelList.add(tuesdayEventsLabel);
    labelList.add(wednesdayEventsLabel);
    labelList.add(thursdayEventsLabel);
    labelList.add(fridayEventsLabel);
    labelList.add(saturdayEventsLabel);
    labelList.add(sundayTasksLabel);
    labelList.add(mondayTasksLabel);
    labelList.add(tuesdayTasksLabel);
    labelList.add(wednesdayTaskLabel);
    labelList.add(thursdayTaskLabel);
    labelList.add(fridayTasksLabel);
    labelList.add(saturdayTasksLabel);
    labelList.add(taskQueueLabel);
    labelList.add(quotesAndNotesLabel);
    labelList.add(sundayDay);
    labelList.add(mondayDay);
    labelList.add(tuesdayDay);
    labelList.add(wednesdayDay);
    labelList.add(thursdayDay);
    labelList.add(fridayDay);
    labelList.add(saturdayDay);
    labelList.add(backgroundLabel);
    labelList.add(fontLabel);
    labelList.add(urlLabel);
    labelList.add(chooseThemeLabel);
    labelList.add(buttonsLabel);
    labelList.add(textColorLabel);
  }

  /**
   * Adds the textAreas to the textAreasList.
   */
  private void addTextAreasToList() {
    textAreaList.add(quotesAndNotes);
  }

  /**
   * Adds the textFlow to the textFlowList.
   */
  private void addTextFlowToList() {
    textFlowList.add(sundayEvents);
    textFlowList.add(mondayEvents);
    textFlowList.add(tuesdayEvents);
    textFlowList.add(wednesdayEvents);
    textFlowList.add(thursdayEvents);
    textFlowList.add(fridayEvents);
    textFlowList.add(saturdayEvents);
  }

  /**
   * Adds the textField to the textFieldList.
   */
  private void addTextFieldToList() {
    textFieldList.add(eventName);
    textFieldList.add(eventDescription);
    textFieldList.add(eventDay);
    textFieldList.add(eventTimeMinute);
    textFieldList.add(eventTimeHour);
    textFieldList.add(eventTimeZone);
    textFieldList.add(eventDuration);
    textFieldList.add(taskName);
    textFieldList.add(taskDay);
    textFieldList.add(taskDescription);
    textFieldList.add(maxEvents);
    textFieldList.add(maxTasks);
  }

  /**
   * Adds the choice box to the choiceBoxList.
   */
  private void addChoiceBoxToList() {
    choiceboxList.add(backgroundChoiceBox);
    choiceboxList.add(buttonChoiceBox);
    choiceboxList.add(textColorChoiceBox);
    choiceboxList.add(fontChoiceBox);
    System.out.println(choiceboxList);
  }

  /**
   * Changes the background in the application to light blue.
   */
  @FXML
  private void changeBackgroundToBlue() {
    anchor.setStyle("-fx-background-color: #a7d9ff;");
    themeSetter.changeTextFlowColorBlue(textFlowList);
    themeSetter.setBlueThemeLabel(labelList);
  }

  /**
   * Changes the background in the application to light green.
   */
  @FXML
  private void changeBackgroundToGreen() {
    anchor.setStyle("-fx-background-color: #9eeab3;");
    themeSetter.changeTextFlowColorGreen(textFlowList);
    themeSetter.setGreenThemeLabel(labelList);
  }

  /**
   * Changes the buttons in the application to light purple.
   */
  @FXML
  private void changeBackgroundToPurple() {
    anchor.setStyle("-fx-background-color: #d0bafd;");
    themeSetter.changeTextFlowColorPurple(textFlowList);
    themeSetter.setPurpleThemeLabel(labelList);
  }

  /**
   * Changes the fonts in the application to Chalkduster.
   */
  @FXML
  private void changeFontToBrushScript() {
    themeSetter.changeButtonFontToBrushScript(buttonList);
    themeSetter.changeLabelFontToBrushScript(labelList);
  }

  /**
   * Changes the fonts in the application to Copperplate.
   */
  @FXML
  private void changeFontToSongti() {
    themeSetter.changeButtonFontToSongti(buttonList);
    themeSetter.changeLabelFontToSongti(labelList);
  }

  /**
   * Changes the fonts in the application to Bodoni 72.
   */
  @FXML
  private void changeFontToBodoni() {
    themeSetter.changeButtonFontToBodoni(buttonList);
    themeSetter.changeLabelFontToBodoni(labelList);
  }

  /**
   * Changes the buttons in the application to light gray.
   */
  @FXML
  private void changeButtonsToLightGray() {
    themeSetter.changeButtonColorWhite(buttonList);
  }

  /**
   * Changes the buttons in the application to light yellow.
   */
  @FXML
  private void changeButtonsToLightYellow() {
    themeSetter.changeButtonColorYellow(buttonList);
  }

  /**
   * Changes the buttons in the application to light red.
   */
  @FXML
  private void changeButtonsToLightRed() {
    themeSetter.changeButtonColorRed(buttonList);
  }

  /**
   * Changes the font color in the application to black.
   */
  @FXML
  private void changeTextColorToBlack() {
    themeSetter.changeButtonTextColorBlack(buttonList);
    themeSetter.changeTextFlowColorBlack(textFlowList);
  }

  /**
   * Changes the font color in the application to white.
   */
  @FXML
  private void changeTextColorToWhite() {
    themeSetter.changeButtonTextColorWhite(buttonList);
    themeSetter.changeTextFlowColorWhite(textFlowList);
  }

  /**
   * Changes the font color in the application to blue.
   */
  @FXML
  private void changeTextColorToBlue() {
    themeSetter.changeButtonTextColorBlue(buttonList);
    themeSetter.changeTextFlowTextColorBlue(textFlowList);

  }

  /**
   * Changes the theme of the application to the Husky theme.
   */
  @FXML
  private void changeThemeToHusky() {
    themeSetter.setHuskyThemeButton(buttonList);
    themeSetter.setHuskyThemeTextFlow(textFlowList);
    themeSetter.setHuskyThemeTextArea(textAreaList);
    themeSetter.setHuskyThemeTextField(textFieldList);
    themeSetter.setHuskyThemeLabel(labelList);
    sceneName.setFill(Color.RED);
    anchor.setStyle("-fx-background-color: red;");
  }

  /**
   * Changes the theme of the application to the Dark theme.
   */
  @FXML
  private void changeThemeToDark() {
    themeSetter.setDarkThemeButton(buttonList);
    themeSetter.setDarkThemeTextFlow(textFlowList);
    themeSetter.setDarkThemeTextArea(textAreaList);
    themeSetter.setDarkThemeTextField(textFieldList);
    themeSetter.setDarkThemeLabel(labelList);
    sceneName.setFill(Color.BLACK);
    anchor.setStyle("-fx-background-color: black;");
  }

  /**
   * Changes the theme of the application to the Light theme.
   */
  @FXML
  private void changeThemeToLight() {
    sceneName.setFill(Color.WHITE);
    themeSetter.setLightThemeButton(buttonList);
    themeSetter.setLightThemeTextFlow(textFlowList);
    themeSetter.setLightThemeTextArea(textAreaList);
    themeSetter.setLightThemeTextField(textFieldList);
    themeSetter.setLightThemeLabel(labelList);
    sceneName.setFill(Color.WHITE);
    anchor.setStyle("-fx-background-color: white;");
  }

  /**
   * Sets up the event handlers for changing the theme in the GUI.
   *
   * @throws IOException if an I/O error occurs.
   */
  @FXML
  private void changeBackgroundInGui() throws IOException {
    backgroundChoiceBox.setOnAction(event -> {
      if (backgroundChoiceBox.getValue().equals("Blue")) {
        changeBackgroundToBlue();
      }
      if (backgroundChoiceBox.getValue().equals("Green")) {
        changeBackgroundToGreen();
      }
      if (backgroundChoiceBox.getValue().equals("Purple")) {
        changeBackgroundToPurple();
      }
    });
  }

  /**
   * Sets up the event handlers for changing the theme in the GUI.
   *
   * @throws IOException if an I/O error occurs.
   */
  @FXML
  private void changeButtonColorInGui() throws IOException {
    buttonChoiceBox.setOnAction(event -> {
      if (buttonChoiceBox.getValue().equals("Light red")) {
        changeButtonsToLightRed();
      }
      if (buttonChoiceBox.getValue().equals("Light yellow")) {
        changeButtonsToLightYellow();
      }
      if (buttonChoiceBox.getValue().equals("Light gray")) {
        changeButtonsToLightGray();
      }
    });
  }

  /**
   * Sets up the event handlers for changing the theme in the GUI.
   *
   * @throws IOException if an I/O error occurs.
   */
  @FXML
  private void changeTextColorsInGui() throws IOException {
    textColorChoiceBox.setOnAction(event -> {
      if (textColorChoiceBox.getValue().equals("Blue")) {
        changeTextColorToBlue();
      }
      if (textColorChoiceBox.getValue().equals("White")) {
        changeTextColorToWhite();
      }
      if (textColorChoiceBox.getValue().equals("Black")) {
        changeTextColorToBlack();
      }
    });
  }

  /**
   * Sets up the event handlers for changing the theme in the GUI.
   *
   * @throws IOException if an I/O error occurs.
   */
  @FXML
  private void changeFontInGui() throws IOException {
    fontChoiceBox.setOnAction(event -> {
      if (fontChoiceBox.getValue().equals("Bodoni 72")) {
        changeFontToBodoni();
      }
      if (fontChoiceBox.getValue().equals("Songti SC")) {
        changeFontToSongti();
      }
      if (fontChoiceBox.getValue().equals("Brush Script MT")) {
        changeFontToBrushScript();
      }
    });
  }

  /**
   * Sets up the event handlers for changing the theme in the GUI.
   *
   * @throws IOException if an I/O error occurs.
   */
  @FXML
  private void changeThemeInGui() throws IOException {
    huskyTheme.setOnAction(e -> changeThemeToHusky());
    darkTheme.setOnAction(e -> changeThemeToDark());
    lightTheme.setOnAction(e -> changeThemeToLight());
  }

  /**
   * Sets values of background choice box
   */
  @FXML
  private void initializeBackgroundChoiceBox() {
    backgroundChoiceBox.setItems(backgroundColor);
  }

  /**
   * Sets values of font choice box
   */
  @FXML
  private void initializeFontChoiceBox() {
    fontChoiceBox.setItems(fontStyle);
  }

  /**
   * Sets values of button choice box
   */
  @FXML
  private void initializeButtonChoiceBox() {
    buttonChoiceBox.setItems(buttonColor);
  }

  /**
   * Sets values of text color choice box
   */
  @FXML
  private void initializeTextColorChoiceBox() {
    textColorChoiceBox.setItems(textColor);
  }
}

