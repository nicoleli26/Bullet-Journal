package cs3500.pa05.model.entries;

import cs3500.pa05.model.entries.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the queue of tasks to display to the user
 * with the name of the task and whether it is complete
 */
public class TaskQueue {
  private List<Task> taskQueue = new ArrayList<>();

  /**
   * @return maps each task in this list of tasks to a String and Boolean
   */
  public Map<String, Boolean> mapper() {
    Map<String, Boolean> map = new HashMap<>();
    for (Task task : taskQueue) {
      map.put(task.getName(), task.getIsComplete());
    }
    return map;
  }

  /**
   * @param task given task to add to this list
   */
  public void addTask(Task task) {
    this.taskQueue.add(task);
  }

  /**
   * @param task given task to remove from this list
   */
  public void removeTask(Task task) {
    this.taskQueue.remove(task);
  }

  /**
   * @return Get this list of task
   */
  public List<Task> getTaskQueue() {
    return this.taskQueue;
  }
}
