package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.ActionPeriod;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a basic implementation of IAnimationModel using IShape as the object type.
 */
public class BasicAnimationModel implements IAnimationModel<IShape> {
  private final List<IShape> listOfShapes;
  private int tick = 0;

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
   * @param index    index of shape (The index will be deducted by
   *                 a method in controller in later assignment by
   *                 using shape's name)
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

  public void addChangePosition(int index, Position position, ActionPeriod ap) {
    getShape(index).addChangePosition(position, ap);
  }

  public void addChangeColor(int index, Color c, ActionPeriod ap) {
    getShape(index).addChangeColor(c, ap);
  }

  @Override
  public void addChangeDimension(int index, Dimension d, ActionPeriod ap) {
    getShape(index).addChangeDimension(d, ap);
  }

  @Override
  public void addObject(IShape shape) {
    int length =listOfShapes.size();
    listOfShapes.add(length, shape);
  }

  @Override
  public void startAnimation() {
    if (listOfShapes.isEmpty()) {
      throw new IllegalStateException("No shape added yet");
    }

    int lastTick = 0;
    while (tick <= lastTick) {
      for (IShape shape : this.listOfShapes) {
        shape.update(this.tick);
      }
    }
  }
}
