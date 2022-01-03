package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class ChangeColorStrategy implements IUpdateStrategy {

    private static IUpdateStrategy ONLY;

    /**
     * Constructor.
     */
    private ChangeColorStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateStrategy make() {
        if (ONLY == null) {
            ONLY = new ChangeColorStrategy();
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     *
     * @return strategy name
     */
    public String getName() {
        return "colorChange";
    }

    /**
     * Update the ball state in the ball world.
     *
     * @param context The ball to update
     */
    public void updateState(Ball context) {
        context.setColor(RandUtil.getRandColor());
        Point vel = context.getVelocity();
        context.nextLocation(new Point(0, (int)vel.y));
    }
}