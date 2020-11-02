package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.ActionPeriod;
import util.Actions;
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
   * @param position  represents the position of the object
   * @param dimension represents the size of the object
   * @throws IllegalArgumentException if the size of the circle exceed the canvas
   *          or the given dimension is negative
   */
  public Circle(String name, Color color, Position position, Dimension dimension)
      throws IllegalArgumentException {
    super(name, color, position, dimension);
    this.diameter = Math.min(dimension.getWidth(), dimension.getHeight());
  }

  /**
   * Sets the size of this circle.
   * @param dimension   the dimension used to set diameter, the minimum of width and height is used
   */

  @Override
   protected void updateDimension(Dimension dimension, ActionPeriod ap) {

    double newDiameter = Math.min(dimension.getWidth(), dimension.getHeight());
    double deltaD = newDiameter / ap.getPeriod();

    this.diameter = this.diameter + deltaD;
  }
}