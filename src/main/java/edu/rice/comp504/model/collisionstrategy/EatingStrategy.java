package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;

public class EatingStrategy implements IUpdateColStrategy {
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private EatingStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new EatingStrategy();
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
        return "Eating";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context,Ball context2) {
        System.out.println("Inside the Eating Update State");
        if (context2.getRadius() > 2) {
            if (context2.getRadius() - context.getRadius() > 0) {
                context2.setRadius(context2.getRadius() - context.getRadius());
            }
        }
        context.setRadius(0);


    }
}