package util;

import model.Canvas;

/**
 * Represents a dimension, which consists of a height and width value, as well as the canvas that is
 * to be placed on.
 * INVARIANT: The dimensions of any given object may not exceed the dimensions of the canvas.
 */
public final class Dimension {
  private final double width;
  private final double height;

  /**
   * Constructor for Dimension class.
   * @param width     the width of an object
   * @param height    the height of an object
   * @param canvas    the canvas to be drawn over
   */
  public Dimension(double width, double height, Canvas canvas) throws IllegalArgumentException {
    if (width > canvas.getWidth() || height > canvas.getHeight()) {
      throw new IllegalArgumentException("Object size cannot exceed the canvas");
    }
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Dimension cannot be negative");
    }
    this.width = width;
    this.height = height;
  }

  /**
   * Retrieves the width of this dimension.
   * @return     the width value
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Retrieves the height of this dimension.
   * @return     the height value
   */
  public double getHeight() {
    return this.height;
  }

}
