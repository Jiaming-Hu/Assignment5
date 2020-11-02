package test;

import static org.junit.Assert.*;

import model.Rectangle;
import org.junit.Test;
import util.ActionPeriod;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * Tests for rectangle class.
 */
public class RectangleTest {

  Rectangle r = new Rectangle("R", new Color(0, 0, 0), new Position(1, 1),
      new Dimension(10, 20));


  //Test for getColor

  /**
   * Check whether two color are equal.
   * @param c1 first color
   * @param c2 second color
   * @return true if two colors are equal, else return false
   */
  private boolean equalColor(Color c1, Color c2) {
    return c1.getR() == c2.getR()
        && c1.getR() == c2.getG()
        && c1.getB() == c2.getB();
  }

  @Test
  public void testGetColor() {
    assertTrue(equalColor(new Color(0, 0, 0), r.getColor()));
  }

// Test for getPosition

  /**
   * check whether two position are the same.
   * @param p1 first position
   * @param p2 second position
   * @return true if their coordinates are the same, else return false
   */
  private boolean equalPosition(Position p1, Position p2) {
    return p1.getX() == p2.getX()
        && p1.getY() == p2.getY();
  }

  @Test
  public void testGetPosition() {
    assertTrue(equalPosition(new Position(1,1), r.getPosition()));
  }

  // Test for getDimension

  /**
   * Check whether two dimensions are the same.
   * @param d1 first dimension
   * @param d2 second dimension
   * @return true if they are the same. else return false
   */
  private boolean equalDimension(Dimension d1, Dimension d2) {
    return d1.getHeight() == d2.getHeight()
        && d1.getWidth() == d2.getWidth();
  }

  @Test
  public void testGetDimension() {
    assertTrue(equalDimension(new Dimension(10, 20), r.getDimension()));
  }

  // Test for addChangePosition
  @Test(expected = IllegalArgumentException.class)
  public void testAddChangePositionCannotAdd() { // time conflict
    r.addChangePosition(new Position(10,10), new ActionPeriod(1, 20));
    r.addChangePosition(new Position(30,10), new ActionPeriod(10, 20));
  }

  @Test
  public void testAddChangePosition() {
    r.addChangePosition(new Position(10,10), new ActionPeriod(1, 20));
    assertEquals(1, r.getActions().getPositionActions().size());
  }

  // Test for addChangeColor
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorCannotAdd() { // time conflict
    r.addChangeColor(new Color(1,2,3), new ActionPeriod(1, 10));
    r.addChangeColor(new Color(1,2,3), new ActionPeriod(5, 10));
  }

  @Test
  public void testAddChangeColor() {
    r.addChangeColor(new Color(1,2,3), new ActionPeriod(1, 10));
    r.addChangeColor(new Color(2,3,4), new ActionPeriod(11, 20));
    r.addChangeColor(new Color(10,20,36), new ActionPeriod(21, 30));
    assertEquals(3, r.getActions().getColorActions().size());
  }

  // Test for addChangeDimension
  @Test(expected = IllegalArgumentException.class)
  public void testChangeDimensionCannotAdd() {
    r.addChangeDimension(new Dimension(10, 20), new ActionPeriod(1, 10));
    r.addChangeDimension(new Dimension(50, 60), new ActionPeriod(9, 10));
  }

  @Test
  public void testAddChangeDimension() {
    r.addChangeDimension(new Dimension(10, 20), new ActionPeriod(1, 2));
    r.addChangeDimension(new Dimension(30, 40), new ActionPeriod(3, 4));
    r.addChangeDimension(new Dimension(60, 60), new ActionPeriod(5, 6));
    r.addChangeDimension(new Dimension(90, 80), new ActionPeriod(7, 8));
    assertEquals(4, r.getActions().getDimensionActions().size());
  }

  @Test
  public void test() {
    r.addChangeColor(new Color(250,250,250), new ActionPeriod(1, 11));
    r.addChangeDimension(new Dimension(20, 40), new ActionPeriod(1, 11));
    r.addChangePosition(new Position(11,11), new ActionPeriod(1, 11));

    r.update(5);
    System.out.print(r);

  }


}