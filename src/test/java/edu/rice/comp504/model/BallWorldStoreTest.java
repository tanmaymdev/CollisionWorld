package edu.rice.comp504.model;

import edu.rice.comp504.adapter.DispatchAdapter;
import edu.rice.comp504.model.collisionstrategy.*;
import edu.rice.comp504.model.ball.*;
import edu.rice.comp504.model.strategy.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class BallWorldStoreTest extends TestCase {
    DispatchAdapter da= new DispatchAdapter();
    BallWorldStore bwS = new BallWorldStore();
    @Test
    public void testloadBall() {

        DispatchAdapter da= new DispatchAdapter();
        BallWorldStore bwS = new BallWorldStore();
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball = bwS.loadBall("Circle", "horizontal","random",false,false);

        assertEquals("Load Circle Shaped Ball","Circle",ball.getName());

    }
    @Test
    public void testAddingBall() {

        DispatchAdapter da= new DispatchAdapter();
        BallWorldStore bwS = new BallWorldStore();
        DispatchAdapter.setCanvasDims(new Point(800,800));
        int size = (bwS.pcs.getPropertyChangeListeners()).length;
        Ball ball = bwS.loadBall("Circle", "horizontal","random",false,false);
        //bwS.addBallToStore(ball);
        System.out.println(size);
        assertEquals("Load Circle Shaped Ball",size+1,(bwS.pcs.getPropertyChangeListeners()).length);

    }

    @Test
    public void testClearBalls() {

        DispatchAdapter da= new DispatchAdapter();
        BallWorldStore bwS = new BallWorldStore();
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball = bwS.loadBall("Circle", "horizontal","random",false,false);
        bwS.addBallToStore(ball);
        assertNotEquals("Some Balls in Ball Store",0,(bwS.pcs.getPropertyChangeListeners()).length);
        bwS.removeBallsFromStore();
        assertEquals("All Balls Cleared",0,(bwS.pcs.getPropertyChangeListeners()).length);

    }

    @Test
    public void testUpdateBalls() {

        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball Circle = bwS.loadBall("Circle", "horizontal","random",false,false);
        IUpdateStrategy Strategy = Circle.getStrategy();
        Circle.setLocation(new Point(5,5));
        Circle.setVelocity(new Point(10,10));
        Circle.setRadius(2);

        if(Strategy.getName() == "vertical")
        {
            Strategy.updateState(Circle);
            assertEquals("Checking next location",new Point(5,15),Circle.getLocation());
        }
        else if(Strategy.getName() == "horizontal")
        {
            Strategy.updateState(Circle);
            assertEquals("Checking next location",new Point(15,5),Circle.getLocation());
        }
        else if(Strategy.getName() == "composite")
        {

            Strategy.updateState(Circle);
            assertEquals("Checking next location",new Point(15,15),Circle.getLocation());
        }
        else{
            Strategy.updateState(Circle);
            assertEquals("Checking next location",new Point((int)(5+Math.round(7.81397247046)),(int)(5+Math.round(11.7873590864))),Circle.getLocation());
        }

        Ball Square = bwS.loadBall("Square", "horizontal","random",false,false);
        IUpdateStrategy Strategy1 = Square.getStrategy();
        Square.setLocation(new Point(5,5));
        Square.setVelocity(new Point(10,10));
        Square.setRadius(2);

        if(Strategy1.getName() == "vertical")
        {
            Strategy1.updateState(Square);
            assertEquals("Checking next location",new Point(5,15),Square.getLocation());
        }
        else if(Strategy1.getName() == "horizontal")
        {
            Strategy1.updateState(Square);
            assertEquals("Checking next location",new Point(15,5),Square.getLocation());
        }
        else if(Strategy1.getName() == "composite")
        {

            Strategy1.updateState(Square);
            assertEquals("Checking next location",new Point(15,15),Square.getLocation());
        }
        else{
            Strategy1.updateState(Square);
            assertEquals("Checking next location",new Point((int)(5+Math.round(7.81397247046)),(int)(5+Math.round(11.7873590864))),Square.getLocation());
        }

        Ball Triangle = bwS.loadBall("Triangle", "horizontal","random",false,false);
        IUpdateStrategy Strategy2 = Triangle.getStrategy();
        Triangle.setLocation(new Point(5,5));
        Triangle.setVelocity(new Point(10,10));
        Triangle.setRadius(2);

        if(Strategy2.getName() == "vertical")
        {
            Strategy2.updateState(Triangle);
            assertEquals("Checking next location",new Point(5,15),Triangle.getLocation());
        }
        else if(Strategy2.getName() == "horizontal")
        {
            Strategy2.updateState(Triangle);
            assertEquals("Checking next location",new Point(15,5),Triangle.getLocation());
        }
        else if(Strategy2.getName() == "composite")
        {

            Strategy2.updateState(Triangle);
            assertEquals("Checking next location",new Point(15,15),Triangle.getLocation());
        }
        else{
            Strategy2.updateState(Triangle);
            assertEquals("Checking next location",new Point((int)(5+Math.round(7.81397247046)),(int)(5+Math.round(11.7873590864))),Triangle.getLocation());
        }

        Ball Pentagon = bwS.loadBall("Pentagon", "horizontal","random",false,false);
        IUpdateStrategy Strategy3 = Pentagon.getStrategy();
        Pentagon.setLocation(new Point(5,5));
        Pentagon.setVelocity(new Point(10,10));
        Pentagon.setRadius(2);

        if(Strategy3.getName() == "vertical")
        {
            Strategy3.updateState(Pentagon);
            assertEquals("Checking next location",new Point(5,15),Pentagon.getLocation());
        }
        else if(Strategy3.getName() == "horizontal")
        {
            Strategy3.updateState(Pentagon);
            assertEquals("Checking next location",new Point(15,5),Pentagon.getLocation());
        }
        else if(Strategy3.getName() == "composite")
        {

            Strategy3.updateState(Pentagon);
            assertEquals("Checking next location",new Point(15,15),Pentagon.getLocation());
        }
        else{
            Strategy3.updateState(Pentagon);
            assertEquals("Checking next location",new Point((int)(5+Math.round(7.81397247046)),(int)(5+Math.round(11.7873590864))),Pentagon.getLocation());
        }

        Ball Hexagon = bwS.loadBall("Hexagon", "horizontal","random",false,false);
        IUpdateStrategy Strategy4 = Hexagon.getStrategy();
        Hexagon.setLocation(new Point(5,5));
        Hexagon.setVelocity(new Point(10,10));
        Hexagon.setRadius(2);

        if(Strategy4.getName() == "vertical")
        {
            Strategy4.updateState(Hexagon);
            assertEquals("Checking next location",new Point(5,15),Hexagon.getLocation());
        }
        else if(Strategy4.getName() == "horizontal")
        {
            Strategy4.updateState(Hexagon);
            assertEquals("Checking next location",new Point(15,5),Hexagon.getLocation());
        }
        else if(Strategy4.getName() == "composite")
        {

            Strategy4.updateState(Hexagon);
            assertEquals("Checking next location",new Point(15,15),Hexagon.getLocation());
        }
        else{
            Strategy4.updateState(Hexagon);
            assertEquals("Checking next location",new Point((int)(5+Math.round(7.81397247046)),(int)(5+Math.round(11.7873590864))),Hexagon.getLocation());
        }

    }
        @Test
    public void testFishBehavior() {
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball = bwS.loadBall("Fish", "horizontal","random",false,false);
        System.out.println(ball.getStrategy().getName());
        ball.setLocation(new Point(780,200));
        ball.setRadius(30);
        ball.strategy.updateState(ball);
        ball.detectCollision();
        assertEquals("Fish Should get flipped",Boolean.TRUE,ball.getFlipped());
        Ball ball1 = bwS.loadBall("Fish", "horizontal","random",false,false);
        ball1.setLocation(new Point(740,200));
        ball1.setRadius(30);
        ball1.setVelocity(new Point(10,10));
        System.out.println("This is Fish velocity"+ball1.getVelocity());
        System.out.println("This is Fish location"+ball1.getLocation());
        ball1.strategy.updateState(ball1);
        ball1.detectCollision();
        System.out.println("This is Fish velocity after update"+ball1.getVelocity());
        System.out.println("THis is fish location after update"+ball1.getLocation());
        assertEquals("Fish Should get Not flipped",Boolean.FALSE,ball1.getFlipped());

    }

    @Test
    public void testColorCollisionStrategy(){
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball1 = bwS.loadBall("Circle", "horizontal","random",false,false);
        Ball ball2 = bwS.loadBall("Circle", "vertical","random",false,false);
        ball1.setLocation(new Point(400,400));
        ball1.setVelocity(new Point(10,10));
        ball1.setRadius(10);
        ball2.setVelocity(new Point(10,10));
        ball2.setLocation(new Point(410,390));
        ball2.setRadius(10);
        ball1.strategy.updateState(ball1);
        ball2.strategy.updateState(ball2);
        ball1.setColStrategy(ColorStrategy.make());
        String ball2Color = ball2.getColor();
        System.out.println("Color Before Collision"+ball2Color);
        ball1.colStrategy.updateState(ball2, ball1);
        System.out.println("Color After Collision"+ball2.getColor());
        assertNotEquals("Color Should get Changed",ball2Color,ball2.getColor());

    }
    @Test
    public void testEatingCollisionStrategy(){
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball1 = bwS.loadBall("Circle", "horizontal","random",false,false);
        Ball ball2 = bwS.loadBall("Circle", "vertical","random",false,false);
        ball1.setLocation(new Point(400,400));
        ball1.setVelocity(new Point(10,10));
        ball1.setRadius(10);
        ball2.setVelocity(new Point(10,10));
        ball2.setLocation(new Point(410,390));
        ball2.setRadius(20);
        ball1.strategy.updateState(ball1);
        ball2.strategy.updateState(ball2);
        ball1.setColStrategy(EatingStrategy.make());
        int ball2Radius = ball2.getRadius();
        System.out.println("Color Before Collision"+ball2Radius);
        ball1.colStrategy.updateState(ball1, ball2);
        System.out.println("Color After Collision"+ball2.getRadius());
        System.out.println(ball1.getRadius());
        assertEquals("Size Should be zer0",0,ball1.getRadius());
        assertNotEquals("Size Should get Changed",ball2Radius,ball2.getRadius());

    }
    @Test
    public void testElasticCollisionStrategy(){
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball1 = bwS.loadBall("Circle", "horizontal","random",false,false);
        Ball ball2 = bwS.loadBall("Circle", "vertical","random",false,false);
        ball1.setLocation(new Point(400,400));
        ball1.setVelocity(new Point(10,10));
        ball1.setRadius(10);
        ball2.setVelocity(new Point(10,10));
        ball2.setLocation(new Point(410,390));
        ball2.setRadius(20);
        ball1.strategy.updateState(ball1);
        ball2.strategy.updateState(ball2);
        ball1.setColStrategy(ElasticStrategy.make());
        Point befVel = ball2.getVelocity();
        System.out.println(befVel);
        ball1.colStrategy.updateState(ball1, ball2);
        Point afVel = ball2.getVelocity();
        assertEquals("Velocity should be negative",true,afVel.x < 0);
    }
    @Test
    public void testMovementCollisionStrategy(){
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball1 = bwS.loadBall("Circle", "horizontal","random",false,false);
        Ball ball2 = bwS.loadBall("Circle", "vertical","random",false,false);
        ball1.setLocation(new Point(400,400));
        ball1.setVelocity(new Point(10,10));
        ball1.setRadius(10);
        ball2.setVelocity(new Point(10,10));
        ball2.setLocation(new Point(410,390));
        ball2.setRadius(20);
        ball1.strategy.updateState(ball1);
        ball2.strategy.updateState(ball2);
        ball1.setColStrategy(MovementStrategy.make());
        String befVel = ball2.getStrategy().getName();
        ball1.colStrategy.updateState(ball1, ball2);
        assertNotEquals("Change in Movement Strategy",befVel,ball2.getStrategy().getName());
    }
    @Test
    public void testRockCollisionStrategy(){
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball1 = bwS.loadBall("Circle", "horizontal","random",false,false);
        Ball ball2 = bwS.loadBall("Circle", "vertical","random",false,false);
        ball1.setLocation(new Point(400,400));
        ball1.setVelocity(new Point(10,10));
        ball1.setRadius(10);
        ball2.setVelocity(new Point(10,10));
        ball2.setLocation(new Point(410,390));
        ball2.setRadius(20);
        ball1.strategy.updateState(ball1);
        ball2.strategy.updateState(ball2);
        ball1.setColStrategy(RockStrategy.make());
        //String befVel = ball2.getStrategy().getName();
        ball1.colStrategy.updateState(ball1, ball2);
        assertEquals("Second Ball Should Stop",new Point(0,0),ball2.getVelocity());
    }
    @Test
    public void testMagicCollisionStrategy(){
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball1 = bwS.loadBall("Circle", "horizontal","random",false,false);
        Ball ball2 = bwS.loadBall("Circle", "vertical","random",false,false);
        ball1.setLocation(new Point(400,400));
        ball1.setVelocity(new Point(10,10));
        ball1.setRadius(10);
        ball2.setVelocity(new Point(10,10));
        ball2.setLocation(new Point(410,390));
        ball2.setRadius(20);
        ball1.strategy.updateState(ball1);
        ball2.strategy.updateState(ball2);
        ball1.setColStrategy(MagicColStrategy.make());
        Point befVel = ball2.getLocation();
        ball1.colStrategy.updateState(ball1, ball2);
        assertNotEquals("New location of ball can be anywhere",befVel,ball2.getLocation());
    }
    @Test
    public void testVelocityCollisionStrategy(){
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball1 = bwS.loadBall("Circle", "horizontal","random",false,false);
        Ball ball2 = bwS.loadBall("Circle", "vertical","random",false,false);
        ball1.setLocation(new Point(400,400));
        ball1.setVelocity(new Point(10,10));
        ball1.setRadius(10);
        ball2.setVelocity(new Point(10,10));
        ball2.setLocation(new Point(410,390));
        ball2.setRadius(20);
        ball1.strategy.updateState(ball1);
        ball2.strategy.updateState(ball2);
        ball1.setColStrategy(VelocityStrategy.make());
        Point befVel = ball2.getVelocity();
        System.out.println(befVel);
        ball1.colStrategy.updateState(ball1, ball2);
        System.out.println(ball2.getVelocity());
        assertEquals("New Velocity of Ball2 will lower",true,ball2.getVelocity().getX() < befVel.getX());
    }
        @Test
    public void testUpdateBallStrategies() {
            DispatchAdapter.setCanvasDims(new Point(800,800));
            Ball ball = Ball.make("Circle", "random", "random", false, false);
            ball.setLocation(new Point(5, 5));
            ball.setVelocity(new Point(10, 10));
            ball.setRadius(10);
            ball.setStrategy(MagicStrategy.make());
            Point currloc = ball.getLocation();
            ball.strategy.updateState(ball);
            assertNotEquals("Location could be anywhere",currloc,ball.getLocation());
            ball.setStrategy(ChangeVelocityStrategy.make());
            Point currVel = ball.getVelocity();
            ball.strategy.updateState(ball);
            assertEquals("Velocity Should Decrease",true,currVel.getX() >  ball.getVelocity().getX());
            ball.setStrategy(ChangeSizeStrategy.make());
            int currRadius = ball.getRadius();
            ball.strategy.updateState(ball);
            assertNotEquals("Ball Size should have changed",currRadius,ball.getRadius());
            ball.setStrategy(ChangeColorStrategy.make());
            String currColor = ball.getColor();
            ball.strategy.updateState(ball);
            assertNotEquals("Ball Color should have changed",currColor,ball.getColor());
        }
    @Test
    public void testSwitchStrategy() {
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball = bwS.loadBall("Circle", "random", "random", true, false);
        //ball.setStrategy(HorizontalStrategy.make());
        String strategy = ball.getStrategy().getName();
        DispatchAdapter.switchStrategy();
        assertNotEquals("Strategy Switched",strategy,ball.getStrategy().getName());

    }
    @Test
    public void testRemoveSome() {
        DispatchAdapter.setCanvasDims(new Point(800,800));
        Ball ball = bwS.loadBall("Circle", "random", "random", true, true);
        Ball ball2 = bwS.loadBall("Circle", "random", "random", true, false);
        int numberofBalls = bwS.pcs.getPropertyChangeListeners().length;
        DispatchAdapter.removeSome();

        assertEquals("Removed only removeable Ball",numberofBalls-1,bwS.pcs.getPropertyChangeListeners().length);

    }
}