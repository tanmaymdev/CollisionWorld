package edu.rice.comp504.model.collisionstrategy;

import edu.rice.comp504.model.ball.Ball;

public class ColStrategyFac implements IColStrategyFac {

    /**
     * Constructor.
     */
    public ColStrategyFac() {

    }
    /**
     * Singleton.
     */
    public static IUpdateColStrategy getColStrategy(String type) {
        if (null != type) {
            switch (type) {

                case "velocity":
                    return VelocityStrategy.make();
                case "movement":
                    return MovementStrategy.make();
                case "color":
                    return ColorStrategy.make();
                case "eating":
                    return EatingStrategy.make();
                case "normal":
                    return ElasticStrategy.make();
                case "elasticncolor":
                    return ElasticColorStrategy.make();
                case "elasticnvelocity":
                    return ElasticVelocityStrategy.make();
                case "elasticnbreathing":
                    return ElasticBreathing.make();
                case "rock":
                    return RockStrategy.make();
                case "magicColStrat":
                    return MagicColStrategy.make();
                case "elasticngravity":
                    return ElasticGravity.make();
                case "gravitynbreathing":
                    return GravityBreathingStrategy.make();
                case "random":
                default:
                    return NullStrategy.make();
            }
        }
        return null;
    }
    /**
     * Strategy Maker.
     */
    public static IUpdateColStrategy make() {
        //randomly select initial strategy
        int sel = (int) Math.floor(Math.random() * 4);
        //System.out.println("This is the Strategy number : "+sel);
        switch (sel) {
            case 0:
                return ColorStrategy.make();
            case 1:
                return EatingStrategy.make();
            case 2:
                return VelocityStrategy.make();
            case 3:
                return MovementStrategy.make();
            default:
                return ElasticStrategy.make();
        }
    }

    /**
     * Switch the strategy.
     * @param ball The current line.
     * @return The new line strategy for the line
     */
    public IColStrategyFac switchStrategy(Ball ball) {
        //System.out.println((context.getStrategy()).getName());
//        switch ((ball.getStrategy()).getName()) {
//            case "horizontal": return VerticalStrategy.make();
//            case "vertical": return CompositeStrategy.make();
//            case "composite": return HorizontalStrategy.make();
//            case "null": return HorizontalStrategy.make();
//            default: return VerticalStrategy.make();
//        }
        return null;
    }
}
