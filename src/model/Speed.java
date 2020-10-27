package model;

/**
 * Represent the speed of x and y direction.
 */
public class Speed {
  private double x;
  private double y;

  /**
   * construct a speed with given value of speed in
   * x and y direction.
   *
   * @param x represents the horizontal speed
   * @param y represents the vertical speed
   *
   */
  public Speed(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
