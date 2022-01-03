package edu.rice.comp504.model.collisionstrategy;

/**
 * A factory that makes Collision strategies.
 */
public interface IColStrategyFac {

    /**
     * Makes a strategy.
     *
     * @return A strategy
     */
    static IColStrategyFac make() {
        return null;
    }
}