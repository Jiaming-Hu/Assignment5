/**
 * 
 */
package model;

/**
 * Represent the size of the canvas with maximum
 * size of 800 * 800.
 */
public class Dimension {
  private double width;
  private double height;

  /**
   * Construct a canvas with given value
   * width and height. The maximum size of the
   * canvas is 800 * 800.
   *
   *
   * @param width represents the horizontal speed
   * @param height represents the vertical speed
   * @throws IllegalArgumentException if the width or height is less
   * than 0 or greater than 800
   *
   */
  public Dimension(double width, double height) throws IllegalArgumentException {
    double [] valueList = {width, height};
    for (double v : valueList) {
      checkValidDimensionValue(v);
    }

    this.width = width;
    this.height = height;
  }

  /**
   * Check whether the dimension value is valid.
   *
   * @param v the given position value
   * @throws IllegalArgumentException if the value less than 0 or greater than 800
   */
  private void checkValidDimensionValue(double v) throws IllegalArgumentException {
    if (v < 0 || v > 800) {
      throw new IllegalArgumentException("The given dimension value is invalid");
    }
  }

  /**
   * Get width of the canvas.
   *
   * @return the value of width
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Get height of the canvas.
   *
   * @return the value of height
   */
  public double getHeight() {
    return this.height;
  }
}
