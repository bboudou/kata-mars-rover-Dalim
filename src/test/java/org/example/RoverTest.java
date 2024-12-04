package org.example;

import org.junit.Test;

public class RoverTest {

    @Test
    public void initialization(){
        Rover roverTest = new Rover();

        assert roverTest.getFacing() == Cardinals.NORTH;
        assert roverTest.getCoord().getX() == 0;
        assert roverTest.getCoord().getY() == 0;
    }

    @Test
    public void GoingNorth(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);

        roverTest.move('F');
        assert roverTest.getFacing() == Cardinals.NORTH;
        assert roverTest.getCoord().getX() == 0;
        assert roverTest.getCoord().getY() == 1;
    }

    @Test
    public void GoingSouth(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);

        roverTest.move('B');
        assert roverTest.getFacing() == Cardinals.NORTH;
        assert roverTest.getCoord().getX() == 0;
        assert roverTest.getCoord().getY() == -1;
    }

    @Test
    public void TurnRight(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);
        roverTest.turn('R');
        assert roverTest.getFacing() == Cardinals.EAST;
        assert roverTest.getCoord().getX() == 0;
        assert roverTest.getCoord().getY() == 0;
    }

    @Test
    public void TurnLeft(){
        Rover roverTest = new Rover(0,0,Cardinals.NORTH);
        roverTest.turn('L');
        assert roverTest.getFacing() == Cardinals.WEST;
        assert roverTest.getCoord().getX() == 0;
        assert roverTest.getCoord().getY() == 0;
    }

    @Test
    public void PassNorthenHemisphereAt0(){

        Rover roverTest = new Rover(0,2,Cardinals.NORTH);
        roverTest.move('F');
        assert roverTest.getFacing() == Cardinals.SOUTH;
        assert roverTest.getCoord().getX() == 3;
        assert roverTest.getCoord().getY() == 2;
    }

    @Test
    public void PassSouthernHemisphere(){

        Rover roverTest = new Rover(2,-2,Cardinals.SOUTH);
        roverTest.move('F');
        assert roverTest.getFacing() == Cardinals.NORTH;
        assert roverTest.getCoord().getX() == -1;
        assert roverTest.getCoord().getY() == -2;
    }

    @Test
    public void PassLimitinEast(){

        Rover roverTest = new Rover(3,-2,Cardinals.EAST);
        roverTest.move('F');
        assert roverTest.getFacing() == Cardinals.EAST;
        assert roverTest.getCoord().getX() == -2;
        assert roverTest.getCoord().getY() == -2;
    }

    @Test
    public void PassLimitinWest(){

        Rover roverTest = new Rover(-2,0,Cardinals.WEST);
        roverTest.move('F');
        assert roverTest.getFacing() == Cardinals.WEST;
        assert roverTest.getCoord().getX() == 3;
        assert roverTest.getCoord().getY() == 0;
    }
    public void MeetObstacle(){}
}
