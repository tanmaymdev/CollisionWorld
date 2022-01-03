package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.ball.Ball;

public class ChangeSizenVelocity implements IUpdateStrategy{
    private static IUpdateStrategy ONLY;
    private IUpdateStrategy[] children;

    /**
     * Constructor.
     */
    private ChangeSizenVelocity(IUpdateStrategy[] children) {
        this.children = children;
    }

    /**
     * Get the singleton composite strategy.
     * @return The singleton composite strategy
     */
    public static IUpdateStrategy make() {
        if (ONLY == null) {
            IUpdateStrategy[] children = new IUpdateStrategy[2];
            children[0] = ChangeSizeStrategy.make();
            children[1] = ChangeVelocityStrategy.make();
            ONLY = new ChangeSizenVelocity(children);
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     * @return strategy name
     */
    public String getName() {
        return "sizenvelocity";
    }

    /**
     * Update the ball state in the ball world.
     * @param ball The ball to update
     */
    public void updateState(Ball ball) {
        System.out.println("Lazy and Breathing");
        for (IUpdateStrategy child: children) {
            child.updateState(ball);
        }
    }
}
