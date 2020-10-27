package model;

import java.awt.Color;

public class Rectangle extends AShape {

  double width;
  double height;

  /**
   * Create a object with basic attributes.
   *
   *
   * @param color     represent the color of the object
   * @param speed     represents the moving speed per tick at x and y direction
   * @param position  represent the position of the object
   * @param dimension represents the background of the canvas
   * @param tick      represents the tick rate per second
   * @param width      represents the width of the rectangle
   * @param height      represents the height of the rectangle
   * @throws IllegalArgumentException if the size of the rectangle exceed the canvas
   *          or the given value of width or height is less than 0
   */
  public Rectangle(String name, Color color, Speed speed, Position position, Dimension dimension,
      double tick, double width, double height) throws IllegalArgumentException {
    super(name, color, speed, position, dimension, tick);

    // width or height is less than 0
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height of a rectangle should be positive");
    }

    // width or height greater than the canvas's width or height
    if (this.width > this.dimension.getWidth() || this.height > this.dimension.getHeight()) {
      throw new IllegalArgumentException("Object size cannot exceed the canvas");
    }
  }

  public void changeDimension(Dimension dimension) {
    this.width = dimension.getWidth();
    this.height = dimension.getHeight();
  }
}
