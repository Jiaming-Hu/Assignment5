package model;

import util.Color;
import util.Dimension;
import util.Position;

/**
 * An abstract class of shape.
 */
public abstract class AShape implements IShape {
  protected String name;
  protected Color color;
  protected Speed speed;
  protected Position position;
  protected Dimension dimension;
  protected Canvas canvas;
  protected double tick;

  /**
   * Create a object with basic attributes.
   *
   * @param name represents the name of the model
   * @param color represents the color of the object
   * @param speed represents the moving speed per tick at x and y direction
   * @param position represents the position of the object
   * @param dimension represents the background of the canvas
   * @param tick represents the tick rate per second
   * @throws IllegalArgumentException   if the tick is negative
   */
  public AShape(String name, Color color, Speed speed, Position position, Dimension dimension,
      Canvas canvas, double tick) throws IllegalArgumentException {

    if (tick < 0) {
      throw new IllegalArgumentException("The given tick value is invalid");
    }

    this.name = name;
    this.color = color;
    this.speed = speed;
    this.position = position;
    this.dimension = dimension;
    this.canvas = canvas;
    this.tick = tick;
  }
  
  @Override
  public Position getPosition() {
    return new Position(this.position.getX(), this.position.getY());
  }

  @Override
  public Color getColor() {
    return new Color(this.color.getR(), this.color.getG(), this.color.getB());
  }

  @Override
  public void updatePosition(Position pos) {
    Position newPosition = new Position(this.position.getX() + pos.getX(),
        this.position.getY() + pos.getY());
  }

  @Override
  public void changeColor(Color c) {
    this.color = c;
  }

  @Override
  public abstract void changeSize(Dimension dimension);


}
