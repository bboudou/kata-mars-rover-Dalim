package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Cardinals.*;

public class Rover {
    private Coordinates coord;
    private Cardinals facing;
    private final Planet planet;
    private final List<Character> listOfDirections = new ArrayList<>(); // commands

    public Rover(){
        coord = new Coordinates();
        facing = NORTH;
        planet=new Planet(-2,3,-2,2);
    }

    public Rover(int x, int y, Cardinals card){
        coord = new Coordinates(x,y);
        facing = card;
        planet=new Planet(-2,3,-2,2);
    }

    public void move(char direction){

        Coordinates lastCoord = new Coordinates(coord.getX(),coord.getY());

        switch (facing) {
            case Cardinals.NORTH:
                coord.setY(moveFunction(direction,coord.getY(),1));
                break;
            case EAST:
                coord.setX(moveFunction(direction,coord.getX(),1));
                break;

            case SOUTH:
                coord.setY(moveFunction(direction,coord.getY(),-1));
                break;

            case WEST:
                coord.setX(moveFunction(direction,coord.getX(),-1));
                break;
        }
        if (planet.inObstacle(coord)){
            faceObstacle(lastCoord);
        }


        planet.OutsideBorder(this);
    }

    private int moveFunction(char direction,int x,int mul) {
        if(direction == 'F'){
            x+=mul;
        }else if(direction == 'B'){
            x-=mul;
        }
        return x;
    }

    public void turn(char direction){
        if (direction=='R')
            facing=Cardinals.byOrdinal((facing.CardOrdinal+1)%4);
        else if (direction == 'L') {
            facing=Cardinals.byOrdinal(facing.CardOrdinal-1);
        }
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public Cardinals getFacing() {
        return facing;
    }

    public void setFacing(Cardinals facing) {
        this.facing = facing;
    }

    public void faceObstacle(Coordinates lastCoord){
        System.out.println("Obstacle found at: "+ coord.getX()+","+coord.getY());
        coord=lastCoord;
    }
}
