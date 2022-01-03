package edu.rice.comp504.model.strategy;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class ChangeSizeStrategy implements IUpdateStrategy {

    private static IUpdateStrategy ONLY;

    /**
     * Constructor.
     */
    private ChangeSizeStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateStrategy make() {
        if (ONLY == null) {
            ONLY = new ChangeSizeStrategy();
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     *
     * @return strategy name
     */
    public String getName() {
        return "sizeChange";
    }

    /**
     * Update the ball state in the ball world.
     *
     * @param context The ball to update
     */
    public void updateState(Ball context) {

        context.setRadius(RandUtil.getRnd(8,((int)(DispatchAdapter.getCanvasDims().x * 0.04) + 8)));
        //context.setRadius(RandUtil.getRnd(8,((int)(800 * 0.04) + 8)));
        Point vel = context.getVelocity();
        context.nextLocation(new Point((int)vel.x,0));
    }
}
