package model;

/**
 * Represents the position of the object.
 */
public class Position {
  private double x;
  private double y;

  /**
   * construct a Position with given value of speed in
   * x and y direction.
   *
   * @param x represents the horizontal speed
   * @param y represents the vertical speed
   * @throws IllegalArgumentException if x or y is less than 0
   */
  public Position(double x, double y) throws IllegalArgumentException {

    this.x = x;
    this.y = y;
  }

  /**
   * Check whether the position value is valid.
   *
   * @param v the given position value
   * @throws IllegalArgumentException if the value less than 0
   */
  private void checkValidPositionValue(double v) throws IllegalArgumentException {
    if (v < 0) {
      throw new IllegalArgumentException("The given position value is invalid");
    }
  }
  
  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }
}
