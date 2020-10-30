package model;

import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a circle shape, which has a diameter value.
 */
public final class Circle extends AShape {
  private double diameter;

  /**
   * Constructor for the circle class.
   * @param name      represents the name of the object
   * @param color     represents the color of the object
   * @param speed     represents the moving speed per tick at x and y direction
   * @param position  represents the position of the object
   * @param dimension represents the size of the object
   * @param canvas    represents the canvas of the animation
   * @param tick      represents the tick rate per second
   * @throws IllegalArgumentException if the size of the circle exceed the canvas
   *          or the given dimension is negative
   */
  public Circle(String name, Color color, Speed speed, Position position, Dimension dimension,
      Canvas canvas, double tick) throws IllegalArgumentException {
    super(name, color, speed, position, dimension, canvas, tick);
    this.diameter = Math.min(dimension.getWidth(), dimension.getHeight());
  }

  /**
   * Sets the size of this circle.
   * @param dimension   the dimension used to set diameter, the minimum of width and height is used
   */
  @Override
  public void changeSize(Dimension dimension) {
    this.diameter = Math.min(dimension.getWidth(), dimension.getHeight());
  }

}