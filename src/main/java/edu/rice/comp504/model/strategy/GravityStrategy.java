package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.ball.Ball;

import java.awt.*;

public class GravityStrategy implements IUpdateStrategy{
    private static IUpdateStrategy ONLY;

    /**
     * Constructor.
     */
    private GravityStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateStrategy make() {
        if (ONLY == null) {
            ONLY = new GravityStrategy();
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     *
     * @return strategy name
     */
    public String getName() {
        return "agile";
    }

    /**
     * Update the ball state in the ball world.
     *
     * @param context The ball to update
     */
    public void updateState(Ball context) {


        Point vel = context.getVelocity();
        vel.setLocation((int)vel.getX() + 5,0);
        if (context.getName() == "Fish") {
            if (vel.x < 0) {
                context.setFlipped(true);
            } else {
                context.setFlipped(false);
            }
        }
        System.out.println(vel.x);
        context.nextLocation(new Point(vel.x, 0));


    }
}
