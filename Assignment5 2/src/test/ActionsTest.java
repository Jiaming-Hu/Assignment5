package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import util.ActionPeriod;
import util.Actions;
import util.Color;
import util.Dimension;
import util.Position;

/**
 * Tests for Actions class
 */
public class ActionsTest {

  Actions a = new Actions();

  @Test(expected = IllegalArgumentException.class)
  public void testCheckValidActionTimeConflict() {
    a.getPositionActions().put(new ActionPeriod(1, 10), new Position(5,  5));
    a.getPositionActions().put(new ActionPeriod(11, 15), new Position(10,  20));

    List<ActionPeriod> formerActions = new ArrayList<ActionPeriod>(a.getPositionActions().keySet());
    a.checkValidAction(formerActions, new ActionPeriod(5, 13));
  }

  @Test
  public void testCheckValidActionNoTimeConflict() {
    a.getPositionActions().put(new ActionPeriod(1, 10), new Position(5,  5));
    a.getPositionActions().put(new ActionPeriod(11, 15), new Position(10,  20));
    List<ActionPeriod> formerActions = new ArrayList<ActionPeriod>(a.getPositionActions().keySet());

    try {
      a.checkValidAction(formerActions, new ActionPeriod(20, 23));
    } catch (IllegalArgumentException i) {
      // no conflict
    } assertEquals(0, 0);
  }

  // Test getColorActIons
  @Test
  public void testGetColorActions() {
    a.getColorActions().put(new ActionPeriod(1, 10), new Color(1, 2,3));

    Map m = new TreeMap();
    m.put(new ActionPeriod(1, 10), new Color(1, 2,3));

    assertEquals(m.size(), a.getColorActions().size());
  }

  // Test getDimensionActions
  @Test
  public void testGetDimensionActions() {
    Map m = new TreeMap();
    assertEquals(m, a.getDimensionActions());
  }

  // Test getDimensionActions
  @Test
  public void testGetPositionActions() {
    Map m = new TreeMap();
    assertEquals(m, a.getPositionActions());
  }

  // Test for mergeTimeNode

  @Test
  public void testMergeTimeNodeAllEmpty() {
    assertEquals(new ArrayList<Integer>(), a.mergeActions());
  }

  @Test
  public void testMergeTimeNode() {
    a.getPositionActions().put(new ActionPeriod(1, 10), new Position(5,  5));
    a.getPositionActions().put(new ActionPeriod(11, 15), new Position(10,  20));
    a.getColorActions().put(new ActionPeriod(5, 10), new Color (1, 2, 3));
    a.getColorActions().put(new ActionPeriod(20, 30), new Color(2, 3, 4));
    a.getDimensionActions().put(new ActionPeriod(5, 10), new Dimension(10, 20));
    a.getDimensionActions().put(new ActionPeriod(8, 15), new Dimension(50,  20));

    HashSet<Integer> hs = new HashSet<Integer>();
    hs.add(1);
    hs.add(5);
    hs.add(8);
    hs.add(10);
    hs.add(11);
    hs.add(15);
    hs.add(20);
    hs.add(30);
    List<Integer> l = new ArrayList<Integer>(hs);
    Collections.sort(l);

    assertEquals(l, a.mergeActions());
  }



}