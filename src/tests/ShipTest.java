package tests;

import game.ship.Rotation;
import game.ship.Ship;
import game.ship.ShipOutOfBoundsException;
import game.ship.ShipType;
import junit.framework.TestCase;


public class ShipTest extends TestCase {

    public void testCreateOutOfBounds(){
        try{
            new Ship(-1,0, Rotation.R270, ShipType.BATTLESHIP);
            fail("Did not throw an exception");
        }
        catch (ShipOutOfBoundsException e){
        }
        try{
            new Ship(0,-1, Rotation.R0, ShipType.BATTLESHIP);
            fail("Did not throw an exception");
        }
        catch (ShipOutOfBoundsException e){
        }
        try{
            new Ship(5,10, Rotation.R0, ShipType.BATTLESHIP);
            fail("Did not throw an exception");
        }
        catch (ShipOutOfBoundsException e){
        }
        try{
            new Ship(0,5, Rotation.R90, ShipType.BATTLESHIP);
            fail("Did not throw an exception");
        }
        catch (ShipOutOfBoundsException e){
        }
        try{
            new Ship(5,0, Rotation.R180, ShipType.BATTLESHIP);
            fail("Did not throw an exception");
        }
        catch (ShipOutOfBoundsException e){
        }
        try{
            new Ship(10,5, Rotation.R270, ShipType.BATTLESHIP);
            fail("Did not throw an exception");
        }
        catch (ShipOutOfBoundsException e){
        }
        assertTrue(true);

    }

    public void testHit(){
        Ship ship = new Ship(5,5,Rotation.R0, ShipType.BATTLESHIP);
        assertTrue("missed 5,5", ship.fire(5,5));
        assertTrue("missed 5,6", ship.fire(5,6));
        assertTrue("missed 5,7", ship.fire(5,7));
        assertTrue("missed 5,8", ship.fire(5,8));
    }

    public void testMiss(){
        Ship ship = new Ship(5,5,Rotation.R0, ShipType.BATTLESHIP);
        assertTrue(!ship.fire(1,1));
    }

    public void testMap(){
        MapTest.test();
    }
}