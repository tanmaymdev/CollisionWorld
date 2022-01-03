package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;

public class ElasticColorStrategy implements IUpdateColStrategy {
    private static IUpdateColStrategy ONLY;
    private IUpdateColStrategy[] children;

    /**
     * Constructor.
     */
    private ElasticColorStrategy(IUpdateColStrategy[] children) {
        this.children = children;
    }

    /**
     * Get the singleton composite strategy.
     * @return The singleton composite strategy
     */
    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            IUpdateColStrategy[] children = new IUpdateColStrategy[2];
            children[0] = ColorStrategy.make();
            children[1] = ElasticStrategy.make();
            ONLY = new ElasticColorStrategy(children);
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     * @return strategy name
     */
    public String getName() {
        return "elasticncolor";
    }

    /**
     * Update the ball state in the ball world.
     * @param ball The ball to update
     */
    public void updateState(Ball ball,Ball ball1) {
        for (IUpdateColStrategy child: children) {
            child.updateState(ball,ball1);
        }
    }
}
