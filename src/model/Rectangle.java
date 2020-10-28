package model;

import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a rectangle shape, which has a width and height.
 */
public final class Rectangle extends AShape {
  private double width;
  private double height;

  /**
   * Create a rectangle shape.
   * @param name      represents the name of the object
   * @param color     represents the color of the object
   * @param speed     represents the moving speed per tick at x and y direction
   * @param position  represents the position of the object
   * @param dimension represents the size of the object
   * @param canvas    represents the canvas of the animation
   * @param tick      represents the tick rate per second
   * @throws IllegalArgumentException if the size of the rectangle exceed the canvas
   *          or the given value of width or height is less than 0
   */
  public Rectangle(String name, Color color, Speed speed, Position position, Dimension dimension,
      Canvas canvas, double tick) throws IllegalArgumentException {
    super(name, color, speed, position, dimension, canvas, tick);
    this.width = dimension.getWidth();
    this.height = dimension.getHeight();
  }

  /**
   * Sets the size of this rectangle.
   * @param dimension     the dimension used to set width and height
   */
  @Override
  public void changeSize(Dimension dimension) {
    this.width = dimension.getWidth();
    this.height = dimension.getHeight();
  }
}
