package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class MagicColStrategy implements IUpdateColStrategy{
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private MagicColStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new MagicColStrategy();
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
        return "MagicColStrategy";
    }

    /**
     * Update the state of the ball.
     *
     * @param context The ball.
     */
    @Override
    public void updateState(Ball context, Ball context2) {
        System.out.println("Inside the Color Update State");
        //context.setColor(RandUtil.getRandColor());
        //context2.setColor(RandUtil.getRandColor());
        Point dimensions = DispatchAdapter.getCanvasDims();
        //Point dimensions = new Point(800,800);
        context2.setLocation(new Point(RandUtil.getRnd( (int) ( 0.08 * dimensions.x), (int) (dimensions.x - ( 0.08 * dimensions.x ))),RandUtil.getRnd( (int) ( 0.08 * dimensions.y),(int)(dimensions.y - ( 0.08 * dimensions.y)))));
    }
}
