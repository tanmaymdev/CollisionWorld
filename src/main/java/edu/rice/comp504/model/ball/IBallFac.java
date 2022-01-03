package edu.rice.comp504.model.ball;

/**
 * A factory that makes balls.
 */
public interface IBallFac {
    /**
     * Makes a ball.
     *
     * @return A Ball
     */
    static Ball make(String type,String strata, Boolean isSwtichable, Boolean isRemoveable) {
        return null;
    }
}
