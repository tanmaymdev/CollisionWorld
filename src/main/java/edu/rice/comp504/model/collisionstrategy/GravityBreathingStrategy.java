package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.model.strategy.ChangeSizeStrategy;
import edu.rice.comp504.model.strategy.GravityStrategy;

public class GravityBreathingStrategy implements IUpdateColStrategy {
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private GravityBreathingStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new GravityBreathingStrategy();
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
        return "gravitynbreathing";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context, Ball context2) {

        context.setStrategy(ChangeSizeStrategy.make());
        context2.setStrategy(GravityStrategy.make());
    }
}
