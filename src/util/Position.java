package util;

/**
 * Represents the position of the object.
 */
public final class Position {
  private final double x;
  private final double y;

  /**
   * Construct a Position with given value of x and y.
   * @param x represents the horizontal location
   * @param y represents the vertical location
   * @throws IllegalArgumentException if x or y is less than 0
   */
  public Position(double x, double y) throws IllegalArgumentException {
    checkValidPositionValue(x);
    checkValidPositionValue(y);
    this.x = x;
    this.y = y;
  }

  /**
   * Check if the position value is valid.
   * @param v the given position value
   * @throws IllegalArgumentException if the value less than 0
   */
  private void checkValidPositionValue(double v) throws IllegalArgumentException {
    if (v < 0) {
      throw new IllegalArgumentException("The given position value is invalid");
    }
  }

  /**
   * Retrieve the x value of this position.
   * @return     x value
   */
  public double getX() {
    return this.x;
  }

  /**
   * Retrieve the y value of this position.
   * @return     y value
   */
  public double getY() {
    return this.y;
  }
}
