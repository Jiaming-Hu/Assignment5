package model;

import java.awt.Color;

public interface IAnimationModel<K> {

    public void move(int index, double x, double y);
    public void changeColor(int index, Color color);
    public void changeSize(int index, Dimension dimension);
    public void addObject(K object);
}
