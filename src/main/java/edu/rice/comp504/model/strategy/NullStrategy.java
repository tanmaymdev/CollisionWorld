package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.ball.Ball;

public class NullStrategy implements IUpdateStrategy{
    private static IUpdateStrategy ONLY;

    private NullStrategy() {

    }

    /**
     * Get the strategy name.
     *
     * @return The strategy name
     */

    public static IUpdateStrategy make() {
        if (ONLY == null ) {
            ONLY = new NullStrategy();
        }
        return ONLY;
    }
    /**
     * Get the strategy name.
     *
     * @return The strategy name
     */
    @Override
    public String getName() {
        return "null";
    }

    /**
     * Update the line state using the behavior defined by the strategy.
     *
     * @param ball The moving line to update
     */
    @Override
    public void updateState(Ball ball) {
        //Point vel = context.getVelocity();
        //context.nextLocation(new Point(0, (int)vel.y));
    }
}
