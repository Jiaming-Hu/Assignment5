package model;

import java.awt.Color;

/**
 * Represents a list of shapes.
 */
public interface IShape {

  public Position getPosition();
  public Color getColor();
  public void updatePosition(double x, double y);
  public void changeColor(Color c);
  public void changeDimension(Dimension dimension);


}
