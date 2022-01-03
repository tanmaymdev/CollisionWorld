package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.util.RandUtil;

public class ColorStrategy implements IUpdateColStrategy{
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private ColorStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new ColorStrategy();
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
        return "Color";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context,Ball context2) {
        System.out.println("Inside the Color Update State");
        context.setColor(RandUtil.getRandColor());
        context2.setColor(RandUtil.getRandColor());
    }
}
