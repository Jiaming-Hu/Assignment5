package model;
import java.awt.Color;

/**
 * An abstract class of object.
 */
public abstract class AShape implements IShape {
  protected String name;
  protected Color color;
  protected Speed speed;
  protected Position position;
  protected Dimension dimension;
  protected double tick;

  /**
   * Create a object with basic attributes.
   *
   * @param name represent the name of the model
   * @param color represent the color of the object
   * @param speed represents the moving speed per tick at x and y direction
   * @param position represent the position of the object
   * @param dimension represents the background of the canvas
   * @param tick represents the tick rate per second
   * @throws IllegalArgumentException
   */
  public AShape(String name, Color color, Speed speed, Position position, Dimension dimension,
      double tick) throws IllegalArgumentException {

    if (tick < 0) {
      throw new IllegalArgumentException("The given tick value is invalid");
    }

    this.name = name;
    this.color = color;
    this.speed = speed;
    this.position = position;
    this.dimension = dimension;
    this.tick = tick;
  }
  
  
  public Position getPosition() {
    return this.position;
  }
  
  public Color getColor() {
    return this.color;
  }
  
  public void updatePosition(double x, double y) {
    Position newPosition = new Position(this.position.getX() + x,
        this.position.getY() + y);
  }

  public void changeColor(Color c) {
    this.color = c;
  }
  
  abstract void changeDimension(Dimension dimension);

  /**
   * Methods :
   *
   * getPosition
   * getColor
   *
   * void methods :
   *
   * move(double x, double y, ) -- update the position
   * changeColor(int r, int g, int b)
   *
   *
   *
   *
   *
   */



}
