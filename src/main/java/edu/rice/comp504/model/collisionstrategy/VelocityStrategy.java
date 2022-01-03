package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;

import java.awt.*;

public class VelocityStrategy implements IUpdateColStrategy {
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private VelocityStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new VelocityStrategy();
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
        return "Velocity";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context,Ball context2) {
        System.out.println("Inside the Velocity Update State");
        context.setVelocity(new Point(context.getVelocity().x + 5,context.getVelocity().y + 5));
        context2.setVelocity(new Point(context2.getVelocity().x - 5,context2.getVelocity().y - 5));
    }
}