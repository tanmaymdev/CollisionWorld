package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.ball.Ball;

public class ChangeColornSizeStrategy implements IUpdateStrategy{

    private static IUpdateStrategy ONLY;
    private IUpdateStrategy[] children;

    /**
     * Constructor.
     */
    private ChangeColornSizeStrategy(IUpdateStrategy[] children) {
        this.children = children;
    }

    /**
     * Get the singleton composite strategy.
     * @return The singleton composite strategy
     */
    public static IUpdateStrategy make() {
        if (ONLY == null) {
            IUpdateStrategy[] children = new IUpdateStrategy[2];
            children[0] = ChangeColorStrategy.make();
            children[1] = ChangeSizeStrategy.make();
            ONLY = new ChangeColornSizeStrategy(children);
        }
        return ONLY;
    }

    /**
     * Get the strategy name.
     * @return strategy name
     */
    public String getName() {
        return "colornsize";
    }

    /**
     * Update the ball state in the ball world.
     * @param ball The ball to update
     */
    public void updateState(Ball ball) {
        for (IUpdateStrategy child: children) {
            child.updateState(ball);
        }
    }
}
