package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;

public class NullStrategy implements IUpdateColStrategy{
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private NullStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new NullStrategy();
        }
        return ONLY;
    }

    /**
     * The name of the strategy.
     *
     * @return strategy name
     */
    @Override
    public String getName() {
        return "null";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context, Ball context2) {
        //System.out.println("Inside the Velocity Update State");
        //context.setVelocity(new Point(context.getVelocity().x+5,context.getVelocity().y+5));

    }
}
