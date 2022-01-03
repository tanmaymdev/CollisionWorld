package edu.rice.comp504.model.ball;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.collisionstrategy.ColStrategyFac;
import edu.rice.comp504.model.collisionstrategy.IUpdateColStrategy;
import edu.rice.comp504.model.strategy.BallStrategyFac;
import edu.rice.comp504.model.strategy.IUpdateStrategy;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class SquareBall extends Ball{
    private static SquareBall ONLY = null;
    /**
     * Constructor.
     *  @param loc      The location of the ball on the canvas
     * @param radius   The ball radius
     * @param vel      The ball velocity
     * @param color    The ball color
     * @param strategy The Strategy
     */
    protected SquareBall(Point loc, int radius, Point vel, String color, IUpdateStrategy strategy, IUpdateColStrategy colStrategy, String name, boolean b,Double rotationAngle,Boolean isSwitchable,Boolean isRemoveable) {
        super(loc, radius, vel, color, strategy,colStrategy,name,false,rotationAngle,isSwitchable,isRemoveable);
    }
    /**
     * Make Function.
     */
    public static SquareBall make(String type,String strata,String colStragety,Boolean isSwitchable,Boolean isRemoveable) {

        Point dimensions = DispatchAdapter.getCanvasDims();
        Point loc = new Point(RandUtil.getRnd( (int) ( 0.08 * dimensions.x), (int) (dimensions.x - ( 0.08 * dimensions.x ))),RandUtil.getRnd( (int) ( 0.08 * dimensions.y),(int)(dimensions.y - ( 0.08 * dimensions.y))));
        int radius = RandUtil.getRnd(5,(int) (dimensions.x * 0.04) + 5);
        Point vel = new Point(RandUtil.getRnd(10,50),RandUtil.getRnd(10,50));
        String color = RandUtil.getRandColor();
        //IUpdateStrategy strategy = BallStrategyFac.make();
        IUpdateStrategy strategy = BallStrategyFac.getStrategy(strata);
        //IUpdateStrategy strategy = ChangeSizeStrategy.make();
        //IUpdateColStrategy colStrategy = ColorStrategy.make();
        IUpdateColStrategy colStrategy = ColStrategyFac.getColStrategy(colStragety);
        //IUpdateColStrategy colStrategy = ColStrategyFac.make();
        String name = "Square";
        Double rotationAngle = 0.0;
        return  new SquareBall(loc,radius,vel,color,strategy,colStrategy,name,false,rotationAngle,isSwitchable,isRemoveable);
    }
}
