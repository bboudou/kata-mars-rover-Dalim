package org.example;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    int limitXmin;
    int limitXmax;
    int limitYmin;
    int limitYmax;
    List<Coordinates> listOfObstacles = new ArrayList<>(List.of(new Coordinates(1, 1), new Coordinates(2, 2), new Coordinates(-1, -1)));

    public Planet(int limitXmin, int limitXmax, int limitYmin, int limitYmax) {
        this.limitXmin = limitXmin;
        this.limitXmax = limitXmax;
        this.limitYmin = limitYmin;
        this.limitYmax = limitYmax;
    }

    public boolean inObstacle(Coordinates coord){
        for (Coordinates coordinate : listOfObstacles) {
            if (coordinate.equals(coord)) return true;
        }
        return false;
    }

    public  Rover OutsideBorder(Rover rover){
        if(rover.getCoord().getX()>limitXmax){
            rover.getCoord().setX(limitXmin);
        }
        if(rover.getCoord().getX()<limitXmin){
            rover.getCoord().setX(limitXmax);
        }
        if(rover.getCoord().getY()<limitYmin){
            rover.getCoord().setY(limitYmin);
            if(rover.getCoord().getX()<=0)
                rover.getCoord().setX(rover.getCoord().getX()+3);
            else
                rover.getCoord().setX(rover.getCoord().getX()-3);
            rover.setFacing(Cardinals.NORTH);
        }

        if(rover.getCoord().getY()>limitYmax){
            rover.getCoord().setY(limitYmax);
            if(rover.getCoord().getX()<=0)
                rover.getCoord().setX(rover.getCoord().getX()+3);
            else
                rover.getCoord().setX(rover.getCoord().getX()-3);
            rover.setFacing(Cardinals.SOUTH);
        }

        return  rover;
    }
}
