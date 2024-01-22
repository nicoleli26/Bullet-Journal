package cs3500.pa05.model.entries;

import java.util.Objects;

/**
 * Represents the Quotes and Notes section of a bullet journal.
 */
public class QuotesAndNotes {

  private String name;
  private String description;

  /**
   * The constructor for the Quotes and Notes.
   *
   * @param description the description of the Quotes and Notes section.
   */
  public QuotesAndNotes(String description) {
    this.name = "Quotes and Notes";
    this.description = description;
  }

  /**
   * Gets the name of the quotes and notes
   *
   * @return the name of quotes and notes
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the description of the Quotes and Notes
   *
   * @return the description quotes and notes
   */
  public String getDescription() {
    return this.description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof QuotesAndNotes q)) {
      return false;
    }
    return getName().equals(q.getName()) && getDescription().equals(q.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDescription());
  }
}
