package model;

import java.awt.Color;
import java.util.List;

public class BasicAnimationModel implements IAnimationModel<IShape> {

  private List<IShape> listOfShapes;

    public BasicAnimationModel() {

    }

    public void move(int index, double x, double y) {
        this.listOfShapes.get(index).updatePosition(x, y);
    }

    public void changeColor(int index, Color color) {
      this.listOfShapes.get(index).changeColor(color);
    }

    public void changeSize(int index, Dimension dimension) {
        this.listOfShapes.get(index).changeDimension(dimension);
    }

    public void addObject(IShape shape) {
        int length =listOfShapes.size();
        listOfShapes.add(length, shape);
    }

}
