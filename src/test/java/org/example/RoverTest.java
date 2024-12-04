package org.example;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    public void initialization(){
        Rover roverTest = new Rover();
        assertEquals(Cardinals.NORTH, roverTest.getFacing());
        assertEquals(0, roverTest.getCoord().getX());
        assertEquals(0, roverTest.getCoord().getY());
    }

    @Test
    public void GoingNorth(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);
        roverTest.move('F');
        testPosition(Cardinals.NORTH,0,1,roverTest);
    }

    @Test
    public void GoingSouth(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);
        roverTest.move('B');
        testPosition(Cardinals.NORTH,0,-1,roverTest);
    }

    @Test
    public void TurnRight(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);
        roverTest.turn('R');
        testPosition(Cardinals.EAST,0,0,roverTest);
    }

    @Test
    public void TurnLeft(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);
        roverTest.turn('L');
        testPosition(Cardinals.WEST,0,0,roverTest);
    }

    @Test
    public void PassNorthenHemisphereAt0(){

        Rover roverTest = new Rover(0,2,Cardinals.NORTH);
        roverTest.move('F');
        testPosition(Cardinals.SOUTH,3,2,roverTest);
    }

    @Test
    public void PassSouthernHemisphere(){

        Rover roverTest = new Rover(2,-2,Cardinals.SOUTH);
        roverTest.move('F');
        testPosition(Cardinals.NORTH,-1,-2,roverTest);
    }

    @Test
    public void PassLimitinEast(){

        Rover roverTest = new Rover(3,-2,Cardinals.EAST);
        roverTest.move('F');
        testPosition(Cardinals.EAST,-2,-2, roverTest);
    }

    @Test
    public void PassLimitinWest(){

        Rover roverTest = new Rover(-2,0,Cardinals.WEST);
        roverTest.move('F');
        testPosition(Cardinals.WEST,3,0,roverTest);
    }
    @Test
    public void MeetObstacle(){
        Rover roverTest = new Rover(1,0,Cardinals.NORTH);
        roverTest.move('F');
        testPosition(Cardinals.NORTH,1,0,roverTest);
    }


    public void testPosition(Cardinals facing, int posx, int posy, Rover roverTest){
        assertEquals(facing, roverTest.getFacing());
        assertEquals(posx, roverTest.getCoord().getX());
        assertEquals(posy, roverTest.getCoord().getY());
    }
}
