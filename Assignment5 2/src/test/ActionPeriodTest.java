package test;

import static org.junit.Assert.*;
import org.junit.Test;
import util.ActionPeriod;

/**
 * Tests for ActionPeriod class.
 */
public class ActionPeriodTest {

  ActionPeriod ap = new ActionPeriod(1, 10);

  // Test for constructor exception
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeStart() {
    ActionPeriod ap = new ActionPeriod(-1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeEnd() {
    ActionPeriod ap = new ActionPeriod(-3, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEndLessThanStart() {
    ActionPeriod ap = new ActionPeriod(10, 1);
  }

  // Test for canAddAction
  @Test
  public void testCanAddActionFalse1() {
    ActionPeriod newAP = new ActionPeriod(2, 10);
    assertFalse(ap.canAddAction(newAP));
  }

  @Test
  public void testCanAddActionFalse2() {
    ActionPeriod newAP = new ActionPeriod(2, 8);
    assertFalse(ap.canAddAction(newAP));
  }

  @Test
  public void testCanAddActionFalse3() {
    ActionPeriod newAP = new ActionPeriod(0, 5);
    assertFalse(ap.canAddAction(newAP));
  }

  @Test
  public void testCanAddActionTrue1() {
    ActionPeriod newAP = new ActionPeriod(11, 15);
    assertTrue(ap.canAddAction(newAP));
  }

  @Test
  public void testCanAddActionTrue2() {
    ActionPeriod newAP = new ActionPeriod(0, 1);
    assertFalse(ap.canAddAction(newAP));
  }

  // Test for getPeriod
  @Test
  public void testGetPeriod() {
    assertEquals(9, ap.getPeriod());
  }

  // Test for GetStart
  @Test
  public void testGetStart() {
    assertEquals(1, ap.getStart());
  }

  // Test for GetEnd
  @Test
  public void testGetEnd() {
    assertEquals(10, ap.getEnd());
  }

}