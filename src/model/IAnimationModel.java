package model;

import util.Color;
import util.Dimension;
import util.Position;

/**
 * Represents a model of an animation.
 * @param <K>     the type of objects to be drawn in the animation
 */
public interface IAnimationModel<K> {

  /**
   * Moves the specified object from current position to given position.
   * @param index        the index of the object to be moved
   * @param position     the new position of the object
   */
  void move(int index, Position position);

  /**
   * Change the color of specified object to the given color.
   * @param index        the index of the object to be moved
   * @param color        the new color of the object
   */
  void changeColor(int index, Color color);

  /**
   * Change the size of the specified object to the given dimension.
   * @param index        the index of the object to be moved
   * @param dimension    the new dimension of the object
   */
  void changeSize(int index, Dimension dimension);

  /**
   * Add the given object to this animation.
   * @param object      object to be added to animation
   */
  void addObject(K object);

}
