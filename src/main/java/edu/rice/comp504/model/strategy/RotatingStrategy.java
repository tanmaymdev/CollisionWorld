package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.ball.Ball;

import java.awt.*;

/**
 * Horizontal strategy moves the line to the right only in the x direction.
 */
public class RotatingStrategy implements IUpdateStrategy {
    private static IUpdateStrategy ONLY;

    /**
     * Constructor.
     */
    private RotatingStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     * @return The vertical strategy
     */
    public static IUpdateStrategy make() {
        if (ONLY == null ) {
            ONLY = new RotatingStrategy();
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     * @return strategy name
     */
    public String getName() {
        return "rotating";
    }

    /**
     * Update the ball state in the ball world.
     * @param context The ball to update
     */
    public void updateState(Ball context) {

        double angle = 0.2;
        Point vel = context.getVelocity();

        if (context.getName() == "Fish") {
            context.setRotationAngle(context.getRotationAngle() + 0.2);
        }
        //else {
        vel.setLocation((vel.x * (Math.cos(angle))) - (vel.y * (Math.sin(angle))), (vel.y * (Math.cos(angle)) + (vel.x * (Math.sin(angle)))));
        System.out.println(vel.getX());
        if (vel.getX() < 0) {
            context.setFlipped(true);
        } else {
            context.setFlipped(false);
        }
        context.nextLocation(new Point((int) vel.getX(), (int) vel.getY()));
       // }
    }
}
