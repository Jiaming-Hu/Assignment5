package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represent the actions of a shape.
 * Keep all the changes in order to add action with time conflict.
 */
public class Actions {

  private Map<ActionPeriod, Color> colorActions;
  private Map<ActionPeriod, Position> positionActions;
  private Map<ActionPeriod, Dimension> dimensionActions;

  /**
   * Create an actions with three actions empty first.
   */
  public Actions() {
    this.colorActions = new TreeMap<ActionPeriod, Color>();
    this.positionActions = new TreeMap<ActionPeriod, Position>();
    this.dimensionActions = new TreeMap<ActionPeriod, Dimension>();
  }

  /**
   * Check whether the given action has time conflict with former actions.
   * @param lap A list of former time period for former actions
   * @param ap the action period of given action
   * @throws IllegalArgumentException if there's a time conflict
   */
  public void checkValidAction(List<ActionPeriod> lap, ActionPeriod ap)
      throws IllegalArgumentException {
    if (!lap.isEmpty()) {
      for (ActionPeriod actionPeriod : lap) {
        if (! actionPeriod.canAddAction(ap)) {
          throw new IllegalArgumentException("Cannot add this action");
        }
      }
    }
  }

  /**
   * Get all the change color actions.
   * @return all the change color actions
   */
  public Map<ActionPeriod, Color> getColorActions() {
    return this.colorActions;
  }

  /**
   * Get all the change dimension actions.
   * @return all the change dimension actions
   */
  /**
   * Get all the change position actions.
   * @return all the change position actions
   */
  public Map<ActionPeriod, Position> getPositionActions() {
    return this.positionActions;
  }

  /**
   * Get all the change dimension actions.
   * @return all the change dimension actions
   */
  public Map<ActionPeriod, Dimension> getDimensionActions() {
    return this.dimensionActions;
  }

  /**
   * Merge All the actions, merge time nodes for
   * all three changes.
   * @return list of time nodes for the shape
   */
  public List<Integer> mergeActions() {

    List<ActionPeriod> positionNodes = new ArrayList<ActionPeriod>(this.positionActions.keySet());
    List<ActionPeriod> colorNodes = new ArrayList<ActionPeriod>(this.colorActions.keySet());
    List<ActionPeriod> dimensionNodes = new ArrayList<ActionPeriod>(this.dimensionActions.keySet());

    // not allow duplicate time nodes
    HashSet<Integer> timeNode = new HashSet<Integer>();
    getTimeNodeForOneAction(timeNode, positionNodes);
    getTimeNodeForOneAction(timeNode, colorNodes);
    getTimeNodeForOneAction(timeNode, dimensionNodes);

    // convert to list
    List<Integer> listOfTimeNode = new ArrayList<Integer>(timeNode);

    // add the start time node
    if (!listOfTimeNode.contains(1) && !listOfTimeNode.isEmpty()) {
      listOfTimeNode.add(1);

    }
    // sort the time node
    Collections.sort(listOfTimeNode);
    return listOfTimeNode;
  }

  /**
   * Get the time node for the actions.
   * @param hs the given set of time nodes
   * @param lap list of action periods waiting for adding time nodes
   * @return a set of time nodes without duplication
   */
  private HashSet<Integer> getTimeNodeForOneAction(HashSet<Integer> hs, List<ActionPeriod> lap) {
    for (ActionPeriod ap : lap) {
      hs.add(ap.getStart());
      hs.add(ap.getEnd());
    }
    return hs;
  }

  /**
   *
   *
   public List<ActionPeriod> mergeActionPeriod() {
   List<Integer> timeNodes = this.mergeActions();
   List<ActionPeriod> lap = new ArrayList<ActionPeriod>();

   for (int i = 0; i + 1 <  timeNodes.size(); i++) {
   lap.add(new ActionPeriod(timeNodes.get(i), timeNodes.get(i + 1)));
   }

   return lap;
   }
   */
}
