package edu.rice.comp504.model.strategy;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class ChangeVelocityStrategy implements IUpdateStrategy {

    private static IUpdateStrategy ONLY;

    /**
     * Constructor.
     */
    private ChangeVelocityStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateStrategy make() {
        if (ONLY == null) {
            ONLY = new ChangeVelocityStrategy();
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     *
     * @return strategy name
     */
    public String getName() {
        return "velocity";
    }

    /**
     * Update the ball state in the ball world.
     *
     * @param context The ball to update
     */
    public void updateState(Ball context) {
        //context.setRadius(RandUtil.getRnd(5,((int)(DispatchAdapter.getCanvasDims().x * 0.04) + 5)));
        context.setVelocity(new Point((int)(context.getVelocity().x * 0.99),(int)(context.getVelocity().y * 0.1)));
        Point vel = context.getVelocity();
        context.nextLocation(new Point((int)vel.getX(),0));
    }
}
