package model;

import java.util.ArrayList;
import java.util.List;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a basic implementation of IAnimationModel using IShape as the object type.
 */
public class BasicAnimationModel implements IAnimationModel<IShape> {
  private final List<IShape> listOfShapes;

  /**
   * Constructor for BasicAnimationModel class.
   * @param shapes     list of shapes in this animation
   */
  public BasicAnimationModel(List<IShape> shapes) {
    this.listOfShapes = shapes;
  }

  /**
   * Default constructor for BasicAnimationModel class. Sets listOfShapes to an empty list.
   */
  public BasicAnimationModel() {
    this.listOfShapes = new ArrayList<>();
  }

  /**
   * Retrieve the shape at given index in listOfShapes.
   * @param index    index of shape
   * @return         shape at given index
   * @throws IllegalArgumentException    if index is out of bounds
   */
  private IShape getShape(int index) throws IllegalArgumentException {
    try {
      return this.listOfShapes.get(index);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Invalid index");
    }
  }

  @Override
  public void move(int index, Position position) {
    getShape(index).updatePosition(position);
  }

  @Override
  public void changeColor(int index, Color color) {
    getShape(index).changeColor(color);
  }

  @Override
  public void changeSize(int index, Dimension dimension) {
    getShape(index).changeSize(dimension);
  }

  @Override
  public void addObject(IShape shape) {
    int length =listOfShapes.size();
    listOfShapes.add(length, shape);
  }

}
