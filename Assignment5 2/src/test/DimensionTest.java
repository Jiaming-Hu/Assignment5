package test;

import static org.junit.Assert.*;

import org.junit.Test;
import util.Dimension;

public class DimensionTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidW() {
    Dimension d = new Dimension(-10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidH() {
    Dimension d = new Dimension(10, -10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidWH() {
    Dimension d = new Dimension(-10, -10);
  }

  @Test
  public void testGetX() {
    Dimension d = new Dimension(1.2, 3.4);
    assertEquals(1.2, d.getWidth(), 0.1);
  }

  @Test
  public void testGetY() {
    Dimension d = new Dimension(2.3, 100.2);
    assertEquals(100.2, d.getHeight(), 0.1);
  }

}