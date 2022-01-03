package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.model.strategy.BallStrategyFac;

public class MovementStrategy implements IUpdateColStrategy {
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private MovementStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new MovementStrategy();
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
        return "Movement";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context,Ball context2) {
        System.out.println("Inside the Movement Update State");
        context.setStrategy(BallStrategyFac.make());
        context2.setStrategy(BallStrategyFac.make());
        //context.setVelocity(new Point(context.getVelocity().x+5,context.getVelocity().y+5));

    }
}