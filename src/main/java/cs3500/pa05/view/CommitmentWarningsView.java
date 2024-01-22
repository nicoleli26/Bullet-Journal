package cs3500.pa05.view;

import java.util.Scanner;

/**
 * Represents the view of a Commitment Warning.
 */
public class CommitmentWarningsView {

  Scanner scanner = new Scanner(System.in);

  /**
   * Gets the Maximum number of tasks
   *
   * @return the maximum number of tasks
   */
  public int getMaxTasks() {
    int maxTasks = 0;
    boolean validInput = false;

    while (!validInput) {
      System.out.println("What is your daily max tasks?");
      String input = scanner.nextLine();

      try {
        maxTasks = Integer.parseInt(input);
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid integer value.");
      }
    }

    return maxTasks;
  }

  /**
   * Gets the maximum number of tasks.
   *
   * @return the maximum number of tasks.
   */
  public int getMaxEvents() {
    int maxEvents = 0;
    boolean validInput = false;

    while (!validInput) {
      System.out.println("What is your daily max events?");
      String input = scanner.nextLine();

      try {
        maxEvents = Integer.parseInt(input);
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid integer value.");
      }
    }
    return maxEvents;
  }
}
