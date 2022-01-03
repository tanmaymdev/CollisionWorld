package edu.rice.comp504.adapter;

import edu.rice.comp504.model.BallWorldStore;

import java.awt.*;
import java.beans.PropertyChangeListener;

/**
 * This adapter interfaces with the view (paint objects) and the controller.
 */
public class DispatchAdapter {
    /**
     * Constructor call.
     */
    private static Point dims;
    public  static BallWorldStore  ballStore = new BallWorldStore();

    public DispatchAdapter() {

    }

    /**
     * Set the canvas dimensions.
     * @param dim The canvas width (x) and height (y).
     */
    public static void setCanvasDims(Point dim) {

        dims = dim;

    }

    public static Point getCanvasDims() {

        return dims;
    }

    /**
     * Update the ball world.
     * @return Balls in BallWorld
     */
    public static PropertyChangeListener[] updateBallWorld() {

        return ballStore.updateBallWorld();
    }

    /**
     * Load a ball into the paint world.
     * @param type The type of object to load on the canvas.
     * @return Balls in BallWorld
     */
    public static PropertyChangeListener loadBall(String type,String strata,String colStrategy,String isSwitchable,String isRemoveable) {

        Boolean isSwitch = true;
        Boolean isRemove = true;
        System.out.println("Is Removeable Property during setup" + isRemoveable);
        System.out.println("Is Switchable Property during setup" + isSwitchable);
        if (isSwitchable.equals("false")) {
            isSwitch = false;
        }
        if (isRemoveable.equals("false")) {
            isRemove = false;
        }
        return ballStore.loadBall(type,strata,colStrategy,isSwitch,isRemove);
    }

    /**
     * Switch Ball/Fish Strategy.
     * @return Switch Completed String in BallWorld.
     */

    public static String switchStrategy() {
        // TODO: fill in
        System.out.println("Inside Dispatch Adapter for Switch Strategy");
        ballStore.switchStrategy();
        return "Switch Done";
    }


    /**
     * Remove all balls from listening for property change events for a particular property.
     * @return Balls in BallWorld
     */
    public static String removeAll() {

        ballStore.removeBallsFromStore();
        return "cleared";
    }
    /**
     * Remove some balls from canvas.
     */
    public  static String removeSome() {

        ballStore.removeSomeBallsFromStore();
        return "Some Removed";
    }

}
