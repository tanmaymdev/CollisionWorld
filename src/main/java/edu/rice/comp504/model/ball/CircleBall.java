package edu.rice.comp504.model.ball;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.collisionstrategy.*;
import edu.rice.comp504.model.strategy.BallStrategyFac;
import edu.rice.comp504.model.strategy.IUpdateStrategy;
import edu.rice.comp504.util.RandUtil;

import java.awt.*;

public class CircleBall extends Ball{
    /**
     * Constructor.
     *  @param loc      The location of the ball on the canvas
     * @param radius   The ball radius
     * @param vel      The ball velocity
     * @param color    The ball color
     * @param strategy The ball Strategy
     */
    protected CircleBall(Point loc, int radius, Point vel, String color, IUpdateStrategy strategy, IUpdateColStrategy colStrategy, String name, boolean b,Double rotationAngle,Boolean isSwitchable,Boolean isRemoveable) {
        super(loc, radius, vel, color, strategy,colStrategy,name,false,rotationAngle,isSwitchable,isRemoveable);
    }

    /**
     * Make Function.
     */
    public static CircleBall make(String type,String strata,String colStragety,Boolean isSwitchable,Boolean isRemoveable) {
        Point dimensions = DispatchAdapter.getCanvasDims();
        //Point dimensions = new Point(800,800);
        Point loc = new Point(RandUtil.getRnd( (int) ( 0.08 * dimensions.x), (int) (dimensions.x - ( 0.08 * dimensions.x ))),RandUtil.getRnd( (int) ( 0.08 * dimensions.y),(int)(dimensions.y - ( 0.08 * dimensions.y))));
        int radius = RandUtil.getRnd(5,(int) (dimensions.x * 0.04) + 5 );
        Point vel = new Point(RandUtil.getRnd(10,50),RandUtil.getRnd(10,50));
        String color = RandUtil.getRandColor();
        //IUpdateStrategy strategy = BallStrategyFac.make();
        IUpdateStrategy strategy = BallStrategyFac.getStrategy(strata);
        //IUpdateStrategy strategy = MagicStrategy.make();
        //IUpdateColStrategy colStrategy = ColStrategyFac.make();
        IUpdateColStrategy colStrategy = ColStrategyFac.getColStrategy(colStragety);
        System.out.println(colStrategy.getName());
        //IUpdateColStrategy colStrategy = ElasticStrategy.make();
        String name = "Circle";
        Double rotationAngle = 0.0;
        Boolean switchit = isSwitchable;
        Boolean removeit = isRemoveable;


        return new CircleBall(loc,radius,vel,color,strategy,colStrategy,name,false,rotationAngle,switchit,removeit);

    }


}
