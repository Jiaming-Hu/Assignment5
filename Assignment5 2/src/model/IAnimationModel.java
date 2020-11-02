package model;

import util.ActionPeriod;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a model of an animation.
 * @param <K>     the type of objects to be drawn in the animation
 */
public interface IAnimationModel<K> {

  /**
   * Add instructions for changing the position of the shape.
   * @param index the index of the object to be moved
   * @param position the new Position of the object
   * @param ap the action period of the object
   */
  void addChangePosition(int index, Position position, ActionPeriod ap);

  /**
   * Add instructions for changing the color of the shape.
   * @param index the index of the object to be moved
   * @param c the new color of the object
   * @param ap the action period of the object
   */
  void addChangeColor(int index, Color c, ActionPeriod ap);

  /**
   * Add instructions for changing the dimension of the shape.
   * @param index the index of the object to be moved
   * @param d the new dimension of the object
   * @param ap the action period of the object
   */
  void addChangeDimension(int index, Dimension d, ActionPeriod ap);

  /**
   * Add the given object to this animation.
   * @param object      object to be added to animation
   */
  void addObject(K object);

  /**
   * Start the animation.
   */
  void startAnimation();
}
