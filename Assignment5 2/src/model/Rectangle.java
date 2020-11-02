package model;

import util.ActionPeriod;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a rectangle shape, which has a width and height.
 */
public final class Rectangle extends AShape {
  
  /**
   * Create a rectangle shape.
   * @param name      represents the name of the object
   * @param color     represents the color of the object
   * @param position  represents the position of the object
   * @param dimension represents the size of the object
   * @throws IllegalArgumentException if the size of the rectangle exceed the canvas
   *          or the given value of width or height is less than 0
   */
  public Rectangle(String name, Color color, Position position, Dimension dimension)
      throws IllegalArgumentException {
    super(name, color, position, dimension);
  }
}
