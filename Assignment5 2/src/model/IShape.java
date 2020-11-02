package model;

import util.ActionPeriod;
import util.Actions;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a shape.
 */
public interface IShape {

  /**
   * Retrieve the position of this shape.
   * @return   position of shape
   */
  Position getPosition();

  /**
   * Retrieve the color of this shape.
   * @return    color of shape
   */
  Color getColor();


  /**
   * Retrieve the dimension of this shape.
   * @return dimension of shape
   */
  Dimension getDimension();


  /**
   * Get all actions of the shape.
   * @return all actions of this shape
   */
  Actions getActions();

  /**
   * Check whether there's time conflict for change position
   * if not, update the action field.
   * @param pos the new position to move this shape to
   * @param ap the action period of this position change
   */
  void addChangePosition(Position pos, ActionPeriod ap);

  /**
   * Check whether there's time conflict for change color
   * if not, update the action field.
   * @param c the new color to change this shape to
   * @param ap the action period of this color change
   */
  void addChangeColor(Color c, ActionPeriod ap);

  /**
   * Check whether there's time conflict for change dimension
   * if not, update the action field.
   * @param dimension the new dimension to change this shape to
   * @param ap the action period of this position change
   */
  void addChangeDimension(Dimension dimension, ActionPeriod ap);

  /**
   * Update the shape at specific tick.
   * @param tick the given tick
   */
  void update(int tick);
}
