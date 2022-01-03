package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;

import java.awt.*;

public class RockStrategy implements IUpdateColStrategy{
    private static IUpdateColStrategy ONLY;

    /**
     * Constructor.
     */
    private RockStrategy() {

    }

    /**
     * Only makes 1 vertical strategy.
     *
     * @return The vertical strategy
     */

    public static IUpdateColStrategy make() {
        if (ONLY == null) {
            ONLY = new RockStrategy();
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
    public void updateState(Ball context, Ball context2) {
        System.out.println("Inside the Eating Update State");
        //Ball ball = Ball.make("circle","random","random",false,false);
        context.getVelocity().x = context.getVelocity().x * -1;
        context.getVelocity().y = context.getVelocity().y * -1;
        context2.setVelocity(new Point(0,0));
       // BallWorldStore.addBallToStore(ball);


    }
}
