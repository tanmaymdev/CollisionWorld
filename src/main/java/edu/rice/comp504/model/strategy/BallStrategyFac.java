package edu.rice.comp504.model.strategy;

import edu.rice.comp504.model.ball.Ball;

/**
 * Factory that creates line strategies.
 */
public class BallStrategyFac implements IStrategyFac {

    /**
     * Constructor.
     */
    public BallStrategyFac() {

    }
    /**
     * Strategy Maker.
     */
    public static IUpdateStrategy getStrategy(String name) {

        switch (name) {

            case "vertical":
                return VerticalStrategy.make();
            case "horizontal":
                return HorizontalStrategy.make();
            case "diagonal":
                return CompositeStrategy.make();
            case "rotating":
                return RotatingStrategy.make();
            case "magic":
                return MagicStrategy.make();
            case "colorful":
                return ChangeColorStrategy.make();
            case "pumping":
                return ChangeSizeStrategy.make();
            case "lazy":
                return ChangeVelocityStrategy.make();
            case "random":
                return BallStrategyFac.make();
            case "colornsize":
                return ChangeColornSizeStrategy.make();
            case "gravity":
                return GravityStrategy.make();
            case "gravitynSize":
                return GravitySizeStrategy.make();
            case "sizenrotating":
                return ChangeSizenRotatingStrategy.make();
            case "sizenvelocity":
                return ChangeSizenVelocity.make();
            default:
                return NullStrategy.make();
        }
    }
    /**
     * Strategy Maker.
     */
    public static IUpdateStrategy make() {
        //randomly select initial strategy
        int sel = (int) Math.floor(Math.random() * 7);

        switch (sel) {
            case 0:
                return HorizontalStrategy.make();
            case 1:
                return VerticalStrategy.make();
            case 2:
                return CompositeStrategy.make();
            case 3:
                return RotatingStrategy.make();
            case 4:
                return ChangeColorStrategy.make();
            case 5:
                return ChangeSizeStrategy.make();
            case 6:
                return ChangeVelocityStrategy.make();
            default:
                return NullStrategy.make();
        }
    }

    /**
     * Switch the strategy.
     * @param ball The current line.
     * @return The new line strategy for the line
     */
    public static IUpdateStrategy switchStrategy(Ball ball) {
        System.out.println((ball.getStrategy()).getName());
        switch ((ball.getStrategy()).getName()) {
            case "horizontal": return RotatingStrategy.make();
            case "rotating": return CompositeStrategy.make();
            case "composite": return ChangeSizeStrategy.make();
            case "sizeChange": return HorizontalStrategy.make();
            default: return HorizontalStrategy.make();
        }

    }
}
