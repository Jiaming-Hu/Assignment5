package model;

import java.awt.Color;

public class Circle extends AShape {
    private double diameter;

    public Circle(String name, Color color, Speed speed, Position position, Dimension dimension,
      double tick, double diameter) throws IllegalArgumentException {
    super(name, color, speed, position, dimension, tick);

    // width or height is less than 0
    if (diameter <= 0) {
      throw new IllegalArgumentException("The diameter of this circle should be positive");
    }

    // width or height greater than the canvas's width or height
    if (this.diameter > this.dimension.getWidth()) {
      throw new IllegalArgumentException("Object size cannot exceed the canvas");
    }
  }

    public void changeDimension(Dimension dimension) {
        this.diameter = dimension.getWidth();
    }
}