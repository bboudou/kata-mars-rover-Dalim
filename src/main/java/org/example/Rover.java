package org.example;

import static org.example.Cardinals.*;

public class Rover {
    private Coordinates coord;
    private Cardinals facing;

    public Rover(){
        coord = new Coordinates();
        facing = NORTH;
    }

    public Rover(int x, int y, Cardinals card){
        coord = new Coordinates(x,y);
        facing = card;
    }

    public void move(char direction){
        switch (this.facing) {
            case Cardinals.NORTH:
                moveNorth(direction);
                break;

            case EAST:
                moveEast(direction);
                break;

            case SOUTH:
                moveSouth(direction);
                break;

            case WEST:
                moveWest(direction);
                break;
        }


    }

    private void moveNorth(char direction) {
        if(direction == 'F'){
            coord.setY(coord.getY()+1);
        }else if(direction == 'B'){
            coord.setY(coord.getY()-1);
        }
    }
    private void moveEast(char direction) {
        if(direction == 'F'){
            coord.setX(coord.getX()+1);
        }else if(direction == 'B'){
            coord.setX(coord.getX()-1);
        }
    }
    private void moveSouth(char direction) {
        if(direction == 'F'){
            coord.setY(coord.getY()-1);
        }else if(direction == 'B'){
            coord.setY(coord.getY()+1);
        }
    }
    private void moveWest(char direction) {
        if(direction == 'F'){
            coord.setX(coord.getX()-1);
        }else if(direction == 'B'){
            coord.setX(coord.getX()+1);
        }
    }

    public void turn(char direction){
        switch (this.facing) {
            case Cardinals.NORTH:
                if (direction=='R')
                    facing=EAST;
                else if (direction == 'L') {
                    facing=WEST;
                }
                break;

            case EAST:
                if (direction=='R')
                    facing=SOUTH;
                else if (direction == 'L') {
                    facing=NORTH;
                }
                break;

            case SOUTH:
                if (direction=='R')
                    facing=WEST;
                else if (direction == 'L') {
                    facing=EAST;
                }
                break;

            case WEST:
                if (direction=='R')
                    facing=NORTH;
                else if (direction == 'L') {
                    facing=SOUTH;
                }
                break;
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
}
