package edu.rice.comp504.model.ball;

import edu.rice.comp504.model.BallWorldStore;
import edu.rice.comp504.model.collisionstrategy.IUpdateColStrategy;
import edu.rice.comp504.model.cmd.IBallImpl;
import edu.rice.comp504.model.strategy.IUpdateStrategy;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The balls that will be drawn in the ball world.
 */
public class Ball implements PropertyChangeListener,IBallFac {
    private Point loc;
    private int radius;
    private Point vel;
    private String color;
    public IUpdateStrategy strategy;
    public IUpdateColStrategy colStrategy;
    private String name;

    public Boolean getFlipped() {
        return isFlipped;
    }

    public void setFlipped(Boolean flipped) {
        isFlipped = flipped;
    }

    private Boolean isFlipped;
    private double rotationAngle;
    private Boolean isSwitchable;
    private Boolean isRemoveable;

    public double getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    /**
     * Constructor.
     * @param loc  The location of the ball on the canvas
     * @param radius The ball radius
     * @param vel  The ball velocity
     * @param color The ball color
     */
    protected Ball(Point loc, int radius, Point vel, String color,IUpdateStrategy strategy,IUpdateColStrategy colStrategy,String name,Boolean isFlipped,Double rotationAngle,Boolean isSwitchable,Boolean isRemoveable) {
        this.loc = loc;
        this.radius = radius;
        this.vel = vel;
        this.color = color;
        this.strategy = strategy;
        this.colStrategy = colStrategy;
        this.name = name;
        this.isFlipped = isFlipped;
        this.rotationAngle = rotationAngle;
        this.isRemoveable = isRemoveable;
        this.isSwitchable = isSwitchable;
    }

    /**
     * Get the ball color.
     * @return ball color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Set the ball color.
     * @param c The new ball color
     */
    public void setColor(String c) {
        this.color = c;
    }


    /**
     * Get the ball location in the ball world.
     * @return The ball location.
     */
    public Point getLocation() {
        return this.loc;
    }


    /**
     * Set the ball location in the canvas.  The origin (0,0) is the top left corner of the canvas.
     * @param loc  The ball coordinate.
     */
    public void setLocation(Point loc) {
        this.loc = loc;
    }

    /**
     * Get the velocity of the ball.
     * @return The ball velocity
     */
    public  Point getVelocity() {
        return this.vel;
    }

    /**
     * Set the velocity of the ball.
     * @param vel The new ball velocity
     */
    public void setVelocity(Point vel) {
        this.vel = vel;
    }


    /**
     * Get the radius of the ball.
     * @return The ball radius.
     */
    public int getRadius() {

        return this.radius;
    }

    /**
     * Set the radius of the ball.
     * @param r The ball radius.
     */
    public void setRadius(int r) {

        this.radius = r;

    }

    public String getName() {

        return this.name;
    }
    /**
     * Set the ball color.
     * @param strategy The new ball color
     */
    public void setStrategy(IUpdateStrategy strategy) {

        this.strategy = strategy;

    }
    /**
     * Used to Get the Strategy.
     */
    public IUpdateColStrategy getColStrategy() {

        return this.colStrategy;
    }
    /**
     * Used to set the colStrategy.
     */
    public void setColStrategy(IUpdateColStrategy colstrategy) {
        this.colStrategy = colstrategy;
    }
    /**
     * Used to Get the Strategy.
     */
    public IUpdateStrategy getStrategy() {

        return this.strategy;

    }

    public Boolean getSwitchable() {
        return isSwitchable;
    }

    public void setSwitchable(Boolean switchable) {
        isSwitchable = switchable;
    }

    public Boolean getRemoveable() {
        return isRemoveable;
    }

    public void setRemoveable(Boolean removeable) {
        isRemoveable = removeable;
    }

    /**
     * Detects collision between a ball and a wall in the ball world.  Change direction if ball collides with a wall.
     * Inspired from Professor Joyner's Code
     */
    public void detectCollision() {

        if (this.name == "Fish") {
            this.detectFishBoundaryCollision();
        } else {
            Point dims = BallWorldStore.getCanvasDims();
            if ((vel.x < 0) && ((loc.x - radius) <= 0)) {
                vel.x = vel.x * -1;
            } else if ((vel.x > 0) && ((loc.x + radius) >= dims.x)) {

                vel.x = vel.x * -1;
            }

            if ((vel.y < 0) && ((loc.y - radius) <= 0)) {

                vel.y = vel.y * -1;
                if (this.name == "Fish") {
                    this.isFlipped = false;
                }

            } else if ((vel.y > 0) && ((loc.y + radius) >= dims.y)) {

                vel.y = vel.y * -1;
                if (this.name == "Fish") {
                    System.out.println("Changing isFlipped to True");
                    this.isFlipped = true;

                }
            }
        }

    }
    /**
     * Detects collision between a Fish and a wall in the ball world.  Change direction if Fish collides with a wall.
     */
    public void detectFishBoundaryCollision() {

        Point dims = new Point(800,800);
        Point loc = this.getLocation();
        Point vel = this.getVelocity();
        int radius = this.getRadius();

        if ((vel.x < 0) && ((loc.x - radius) <= 0)) {
            vel.x = vel.x * - 1;
            this.isFlipped = false;

        } else if ((vel.x > 0) && ((loc.x + radius) >= (dims.x - 10))) {

            vel.x = vel.x * - 1;
            this.isFlipped = true;

        }
        if ((vel.y < 0) && ((loc.y - radius) <= 0)) {

            vel.y = vel.y * - 1;

        } else if ((vel.y > 0) && ((loc.y + radius) >= dims.y)) {

            vel.y = vel.y * - 1;

        }

    }
    /**
     * Detects collision between a Ball and a Ball in the ball world. Use Collision Strategy if Ball collides with a Ball.
     */
    public boolean detectCollisionBall(Ball wall) {
        Point wallLoc = wall.getLocation();
        // ball crosses wall in the x direction
        boolean crossedWallX = ((loc.x < wallLoc.x) && ((loc.x + radius) >= (wallLoc.x - wall.radius))) ||
                (loc.x > wallLoc.x && ((loc.x - radius <= (wallLoc.x + wall.radius))));

        //ball crosses wall in the y direction
        boolean crossedWallY = ((loc.y < wallLoc.y) && ((loc.y + radius) >= (wallLoc.y))) ||
                (loc.y > wallLoc.y && ((loc.y - radius <= (wallLoc.y))));
        return crossedWallX && crossedWallY;
        //return crossedWallX;
    }

    @Override
    /**
     *  Ball responds to the property change support indicating that property has changed.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        ((IBallImpl) evt.getNewValue()).execute(this);
    }

    /**
     *  Determine nextLocation of Ball.
     */
    public void nextLocation(Point vel) {

        this.loc.translate((int) vel.getX(), (int) vel.getY());
    }


    /**
     * Makes a ball.
     */
    public static Ball make(String type,String strategy,String colStrategy,Boolean isSwitchable,Boolean isRemoveable) {

        Ball ball = null;
        if (type.equals("Circle") && type != null) {

            ball = CircleBall.make(type,strategy,colStrategy,isSwitchable,isRemoveable);

        } else if (type.equals("Square") && type != null) {

            ball =  SquareBall.make(type,strategy,colStrategy,isSwitchable,isRemoveable);

        } else if (type.equals("Pentagon") && type != null) {

            ball =  PentagonalBall.make(type,strategy,colStrategy,isSwitchable,isRemoveable);

        } else if (type.equals("Hexagon") && type != null) {

            ball =  HexagonalBall.make(type,strategy,colStrategy,isSwitchable,isRemoveable);

        } else if (type.equals("Triangle") && type != null) {

            ball =  TriangleBall.make(type,strategy,colStrategy,isSwitchable,isRemoveable);
        } else if (type.equals("Fish") && type != null) {

            ball =  FishBall.make(type,strategy,colStrategy,isSwitchable,isRemoveable);
        }

        return ball;
    }

}
