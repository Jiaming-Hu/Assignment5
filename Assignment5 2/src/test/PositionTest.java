package test;

import static org.junit.Assert.*;

import org.junit.Test;
import util.Position;

public class PositionTest {

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidX() {
    Position p = new Position(-10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidY() {
    Position p = new Position(10, -10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidXY() {
    Position p = new Position(-10, -10);
  }

  @Test
  public void testGetX() {
    Position p = new Position(11.3, 10.6);
    assertEquals(11.3, p.getX(), 0.1);
  }

  @Test
  public void testGetY() {
    Position p = new Position(1.2, 11.5);
    assertEquals(11.5, p.getY(), 0.1);
  }


}