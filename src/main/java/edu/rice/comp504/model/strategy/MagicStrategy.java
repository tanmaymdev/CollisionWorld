package edu.rice.comp504.model.strategy;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class MagicStrategy implements IUpdateStrategy {
    private static IUpdateStrategy ONLY;

    /**
     * Constructor.
     */
    private MagicStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateStrategy make() {
        if (ONLY == null) {
            ONLY = new MagicStrategy();
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     *
     * @return strategy name
     */
    public String getName() {
        return "magic";
    }

    /**
     * Update the ball state in the ball world.
     *
     * @param context The ball to update
     */
    public void updateState(Ball context) {
        //Point vel = context.getVelocity();
        //context.nextLocation(new Point(0, (int)vel.y));
        Point dimensions = DispatchAdapter.getCanvasDims();
        //Point dimensions = new Point(800,800);
        context.setLocation(new Point(RandUtil.getRnd( (int) ( 0.08 * dimensions.x), (int) (dimensions.x - ( 0.08 * dimensions.x ))),RandUtil.getRnd( (int) ( 0.08 * dimensions.y),(int)(dimensions.y - ( 0.08 * dimensions.y)))));
    }
}
