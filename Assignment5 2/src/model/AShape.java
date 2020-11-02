package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import util.ActionPeriod;
import util.Actions;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * An abstract class of shape.
 */
public abstract class AShape implements IShape {
  protected String name;
  protected Color color;
  protected Position position;
  protected Dimension dimension;
  protected Actions actions;
  protected ArrayList<String> actionText;

  /**
   * Create a object with basic attributes.
   *
   * @param name represents the name of the model
   * @param color represents the color of the object
   * @param position represents the position of the object
   * @param dimension represents the background of the canvas
   * @throws IllegalArgumentException   if the tick is negative
   */
  public AShape(String name, Color color, Position position, Dimension dimension)
      throws IllegalArgumentException {

    this.name = name;
    this.color = color;
    this.position = position;
    this.dimension = dimension;
    this.actions = new Actions();
    this.actionText = new ArrayList<String>();
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
  public Dimension getDimension() {
    return new Dimension(this.dimension.getWidth(), this.dimension.getHeight());
  }

  @Override
  public Actions getActions() {
    return this.actions;
  }

  @Override
  public void addChangePosition(Position pos, ActionPeriod ap) {
    // check whether the given action period is valid
    List<ActionPeriod> lap = new ArrayList<ActionPeriod>();
    for (Map.Entry<ActionPeriod, Position> e : actions.getPositionActions().entrySet()) {
      lap.add(e.getKey());
    }
    this.actions.checkValidAction(lap, ap);
    // no conflict
    this.actions.getPositionActions().put(ap, pos);
  }


  @Override
  public void addChangeColor(Color c, ActionPeriod ap) {

    // check whether the given action period is valid
    List<ActionPeriod> lap = new ArrayList<ActionPeriod>();
    for (Map.Entry<ActionPeriod, Color> e : actions.getColorActions().entrySet()) {
      lap.add(e.getKey());
    }
    this.actions.checkValidAction(lap, ap);
    // no conflict
    this.actions.getColorActions().put(ap, c);
  }


  @Override
  public void addChangeDimension(Dimension dimension, ActionPeriod ap) {
    // check whether the given action period is valid
    List<ActionPeriod> lap = new ArrayList<ActionPeriod>();
    for (Map.Entry<ActionPeriod, Dimension> e : actions.getDimensionActions().entrySet()) {
      lap.add(e.getKey());
    }
    this.actions.checkValidAction(lap, ap);
    // no conflict
    this.actions.getDimensionActions().put(ap, dimension);
  }

  @Override
  public void update(int tick) {

    List<ActionPeriod> positionActionPeriod = new ArrayList<ActionPeriod>(
        this.actions.getPositionActions().keySet());
    List<ActionPeriod> colorActionPeriod = new ArrayList<ActionPeriod>(
        this.actions.getColorActions().keySet());
    List<ActionPeriod> dimensionActionPeriod = new ArrayList<ActionPeriod>(
        this.actions.getDimensionActions().keySet());

    // update position
    ActionPeriod positionAP = getActionPeriodByTick(tick, positionActionPeriod);
    if (positionAP != null ) {
      Position newPos = this.actions.getPositionActions().get(positionAP);
      updatePosition(newPos, positionAP);
    }

    // update color
    ActionPeriod colorAP = getActionPeriodByTick(tick, colorActionPeriod);
    if (positionAP != null ) {
      Color newCol = this.actions.getColorActions().get(colorAP);
      updateColor(newCol, colorAP);
    }

    // update dimension
    ActionPeriod dimensionAP = getActionPeriodByTick(tick, dimensionActionPeriod);
    if (positionAP != null ) {
      Dimension newDim = this.actions.getDimensionActions().get(dimensionAP);
      updateDimension(newDim, dimensionAP);
    }
  }

  /**
   * Use the delta position and the action period
   * to calculate the speed, update position of the shape for one tick.
   * @param pos the new Position of the shape
   * @param ap the action period of the shape
   */
  protected void updatePosition(Position pos, ActionPeriod ap) {
    double currentX = this.position.getX();
    double currentY = this.position.getY();

    double deltaX = (pos.getX() - currentX) / ap.getPeriod();
    double deltaY = (pos.getY() - currentY) / ap.getPeriod();

    Position newPosition = new Position(currentX + deltaX,
        currentY + deltaY);
    this.position = newPosition;
  }

  /**
   * Use the delta color and the action period
   * to calculate the changing speed of the color,
   * update color of the shape for one tick.
   * @param c the new color of the shape
   * @param ap the action period of the shape
   */
  protected void updateColor(Color c, ActionPeriod ap) {
    int r = this.color.getR();
    int g = this.color.getG();
    int b = this.color.getB();

    int deltaR = (int) Math.floor((c.getR() - r) / ap.getPeriod());
    int deltaG = (int) Math.floor((c.getG() - g) / ap.getPeriod());
    int deltaB = (int) Math.floor((c.getB() - b) / ap.getPeriod());

    Color newColor = new Color(r + deltaR, g + deltaG,b + deltaB);
    this.color = newColor;
  }

  /**
   * Use the delta dimension and the action period
   * to calculate the changing speed of the dimension,
   * update dimension of the shape for one tick.
   * @param dimension the new dimension of the shape
   * @param ap the action period of the shape
   */
  protected void updateDimension(Dimension dimension, ActionPeriod ap) {

    double currentWidth = this.dimension.getWidth();
    double currentHeight = this.dimension.getHeight();

    double deltaW = (dimension.getWidth() - currentWidth) / ap.getPeriod();
    double deltaH = (dimension.getHeight() - currentHeight) / ap.getPeriod();

    Dimension newDimension = new Dimension(currentWidth + deltaW,
        currentHeight + deltaH);

    this.dimension = newDimension;
  }

  /**
   * Check the given tick falls into which action period.
   * @param tick the given tick
   * @param lap A list of action period of one type of change.
   * @return the action period that the tick falls into
   *          null if there's no such action period
   */
  private ActionPeriod getActionPeriodByTick(int tick, List<ActionPeriod> lap) {
    for (ActionPeriod ap : lap) {
      if (tick >= ap.getStart() && tick < ap.getEnd()) {
        return ap;
      }
    }
    return null;
  }

  /**
   * Get information of the current shape.
   * @param tick the current tick
   * @return a string represents the shape information.
   */
  private String infoString(int tick) {
    String infoString = "";

    String t = String.valueOf(tick);
    String x = String.valueOf(this.position.getX());
    String y = String.valueOf(this.position.getY());
    String w = String.valueOf(this.dimension.getWidth());
    String h = String.valueOf(this.dimension.getHeight());
    String r = String.valueOf(this.color.getR());
    String g = String.valueOf(this.color.getG());
    String b = String.valueOf(this.color.getB());

    int i = 1;
    for (String s : new ArrayList<String>(Arrays.asList(t, x, y, w, h, r, g, b))) {
      if (i < 8) {
        infoString = infoString + s + " ";
      } else {
        infoString = infoString + s;
      }
    }
    return infoString;
  }
}
