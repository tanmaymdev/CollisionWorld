package edu.rice.comp504.model.cmd;

import edu.rice.comp504.model.BallWorldStore;
import edu.rice.comp504.model.ball.Ball;
import edu.rice.comp504.model.strategy.BallStrategyFac;

import java.beans.PropertyChangeListener;

public class IBallImpl implements IBallCmd{

    private final PropertyChangeListener[] iWalls;


    public IBallImpl(PropertyChangeListener[] iWalls) {
        this.iWalls = iWalls;
    }
    /**
     * Execute the command.
     *
     * @param context The receiver on which the command is executed.
     */

    public void execute(Ball context) {

        context.detectCollision();
        for (PropertyChangeListener pcl : iWalls) {
            if (context.detectCollisionBall((Ball)pcl)) {
                if (context.getName() != "Fish") {
                    if (((Ball) pcl).getName() != "Fish") {
                        context.colStrategy.updateState((Ball) pcl, context);
                    } else {
                        //Fish tries to avoid collision by changing strategy
                        System.out.println("Inside Fish Switches");
                        BallStrategyFac.switchStrategy((Ball) pcl);
                    }
                }
            }
        }
        context.strategy.updateState(context);
    }
}
