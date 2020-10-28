package model;

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
   * Update the position of this shape.
   * @param position    the new position to move this shape to
   */
  void updatePosition(Position position);

  /**
   * Update the color of this shape.
   * @param c    the new color to change this shape to
   */
  void changeColor(Color c);

  /**
   * Update the size of this shape.
   * @param dimension    the dimension to change this shape to
   */
  void changeSize(Dimension dimension);


}
