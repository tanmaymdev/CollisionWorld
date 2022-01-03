package edu.rice.comp504.model;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.ball.*;
import edu.rice.comp504.model.cmd.IBallImpl;
import edu.rice.comp504.model.strategy.BallStrategyFac;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A store containing current Ball World.
 */
public class BallWorldStore {
    public static PropertyChangeSupport pcs;
    private static Point dims;
    private  Ball ball;

    /**
     * Constructor.
     */
    public BallWorldStore() {
        pcs = new PropertyChangeSupport(this);
    }

    /**
     * Get the canvas dimensions.
     * @return The canvas dimensions
     */
    public static Point getCanvasDims() {

        dims =  DispatchAdapter.getCanvasDims();
        return dims;
    }

    /**
     * Set the canvas dimensions.
     * @param dims The canvas width (x) and height (y).
     */
    public static void setCanvasDims(String dims) {

    }

    /**
     * Call the update method on all the ball observers to update their position in the ball world.
     */
    public PropertyChangeListener[] updateBallWorld() {

        this.pcs.firePropertyChange("theClock",null, new IBallImpl(this.pcs.getPropertyChangeListeners("theClock")));
        return this.pcs.getPropertyChangeListeners("theClock");

    }

    /**
     * Load a ball into the Ball World.
     * @param type  The REST request body has the strategy names.
     * @return A ball
     */
    public Ball loadBall(String type,String strata,String colStrategy,Boolean isSwitchable,Boolean isRemoveable) {

        Ball ball = Ball.make(type,strata,colStrategy,isSwitchable,isRemoveable);
        addBallToStore(ball);
        return ball;
    }
    /**
     * Switch the strategy of switcher balls.
     */
    public void switchStrategy() {

        PropertyChangeListener[] pclArr = pcs.getPropertyChangeListeners("theClock");
        //System.out.println("Removing removeable Ball");
        for (PropertyChangeListener pcl: pclArr) {
            Ball b = (Ball)pcl;
            System.out.println("This is Switchable Property:" + b.getSwitchable());
            if (b.getSwitchable() == true) {
                b.setStrategy(BallStrategyFac.switchStrategy(b));
            }
        }

        //return this.pcs.getPropertyChangeListeners("theClock");
    }

    /**
     * Add a ball that will listen for a property change (i.e. time elapsed)
     * @param pcl  The ball
     */
    public static void addBallToStore(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener("theClock", pcl);
    }
    /**
     * Remove all balls from listening for property change events for a particular property.
     */
    public void removeBallsFromStore() {
        PropertyChangeListener[] pclArr = pcs.getPropertyChangeListeners();
        for (PropertyChangeListener pcl: pclArr) {
            pcs.removePropertyChangeListener(pcl);
        }
    }
    /**
     * Remove some balls from listening for property change events for a particular property.
     */
    public void removeSomeBallsFromStore() {
        PropertyChangeListener[] pclArr = pcs.getPropertyChangeListeners("theClock");
        System.out.println("Removing removeable Ball");
        for (PropertyChangeListener pcl: pclArr) {
            Ball b = (Ball)pcl;
            System.out.println("This is Removeable Property:" + b.getRemoveable());
            if (b.getRemoveable() == true) {
                System.out.println("Removing removeable Ball Inside If");
                pcs.removePropertyChangeListener("theClock",pcl);
            }
        }
    }
}
