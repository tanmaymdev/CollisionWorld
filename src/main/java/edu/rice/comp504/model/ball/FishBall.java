package edu.rice.comp504.model.ball;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.collisionstrategy.IUpdateColStrategy;
import edu.rice.comp504.model.collisionstrategy.NullStrategy;
import edu.rice.comp504.model.strategy.*;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class FishBall extends Ball{

    /**
     * Constructor.
     *  @param loc      The location of the ball on the canvas
     * @param radius   The ball radius
     * @param vel      The ball velocity
     * @param color    The ball color
     * @param strategy The Fish Strategy
     */
    protected FishBall(Point loc, int radius, Point vel, String color, IUpdateStrategy strategy, IUpdateColStrategy colStrategy, String name, Boolean isFlipped,Double rotationAngle,Boolean isSwitchable,Boolean isRemoveable) {
        super(loc, radius, vel, color, strategy,colStrategy, name,false,rotationAngle,isSwitchable,isRemoveable);
    }

    /**
     * Make Function.
     */
    public static FishBall make(String type,String strata,String colStragety,Boolean isSwitchable,Boolean isRemoveable) {
        Point dimensions = DispatchAdapter.getCanvasDims();
        System.out.println(dimensions);
        Point loc = new Point(RandUtil.getRnd( (int) ( 0.08 * dimensions.x), (int) (dimensions.x - ( 0.08 * dimensions.x ))),RandUtil.getRnd( (int) ( 0.08 * dimensions.y),(int)(dimensions.y - ( 0.08 * dimensions.y))));
        int radius = RandUtil.getRnd(20,(int) (dimensions.x * 0.04) + 20 );
        Point vel = new Point(RandUtil.getRnd(10,40),RandUtil.getRnd(10,40));
        String color = RandUtil.getRandColor();
        IUpdateStrategy strategy = BallStrategyFac.getStrategy(strata);
        if (strategy.getName() == "vertical" || strategy.getName() == "colorChange" || strategy.getName() == "colornsize") {

            strategy = HorizontalStrategy.make();
        }
        IUpdateColStrategy colStrategy = NullStrategy.make();
        String name = "Fish";
        Boolean isFlipped = false;
        Double rotationAngle = 0.0;
        return new FishBall(loc,radius,vel,color,strategy,colStrategy,name,isFlipped,rotationAngle,isSwitchable,isRemoveable);

    }
}
