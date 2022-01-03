package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.model.strategy.ChangeSizeStrategy;

public class ElasticBreathing implements IUpdateColStrategy {
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private ElasticBreathing() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new ElasticBreathing();
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
        return "Elastic";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context, Ball context2) {

        context.setStrategy(ChangeSizeStrategy.make());
        context.getVelocity().x = context.getVelocity().x * -1;
        context.getVelocity().y = context.getVelocity().y * -1;
        context2.getVelocity().x = context2.getVelocity().x * -1;
        context2.getVelocity().y = context2.getVelocity().y * -1;
    }
}
