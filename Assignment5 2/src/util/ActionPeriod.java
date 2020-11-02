package util;

/**
 * Represents the period of an action.
 */
public class ActionPeriod implements Comparable<ActionPeriod> {

  private final int start;
  private final int end;

  /**
   * Construct an ActionPeriod with given start and end time.
   * @param start the action start time
   * @param end the action end time
   */
  public ActionPeriod(int start, int end) {

    // is start less than 0 or end is less than start
    if (end <= start || start < 0) {
      throw new IllegalArgumentException("Invalid action period");
    }
    this.start = start;
    this.end = end;
  }

  /**
   * Check whether two Action period have duplicate period.
   * @param ap the given action period
   * @return true if there's no time conflict, else return false
   */
  public boolean canAddAction(ActionPeriod ap) {
    int start = ap.start;
    int end = ap.end;

    if (this.end >= start && start >= this.start) {
      return false;
    }

    else if (this.start <= end && end <= this.end) {
      return false;
    }
    return true;
  }

  /**
   * Get total action time of the action period.
   * @return the action time
   */
  public int getPeriod() {
    return this.end - this.start;
  }

  /**
   * Get the start time of the action.
   * @return the action start time
   */
  public int getStart() {
    return start;
  }

  /**
   * Get the end time of the action
   * @return the action end time
   */
  public int getEnd() {
    return end;
  }

  /**
   * Compare two action period based on the start time.
   * @param o the given action period
   * @return -1 if the given action period start time is greater
   *          1 if the this given action period time is greater
   *          0 if equals.
   */
  @Override
  public int compareTo(ActionPeriod o) {
    if (this.start < o.getStart()) {
      return -1;
    }
    if (this.start > o.getStart()) {
      return 1;
    }
    return 0;
  }
}
