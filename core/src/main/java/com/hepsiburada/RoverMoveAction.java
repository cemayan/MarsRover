package com.hepsiburada;

import com.hepsiburada.enums.Direction;

public class RoverMoveAction {


    public static Direction Left(Direction roverDirection){

        Direction calcDirection = Direction.INIT;

        switch (roverDirection) {

            case N:
                calcDirection =  Direction.W;
                break;
            case S:
                calcDirection =  Direction.E;
                break;
            case W:
                calcDirection =  Direction.S;
                break;
            case E:
                calcDirection =  Direction.N;
                break;
            default:
                calcDirection = Direction.INIT;
        }

        return calcDirection;
    }

    public static Direction Right(Direction roverDirection) {

        Direction calcDirection = Direction.INIT;;

        switch (roverDirection) {

            case N:
                calcDirection =  Direction.E;
                break;
            case S:
                calcDirection =  Direction.W;
                break;
            case W:
                calcDirection =  Direction.N;
                break;
            case E:
                calcDirection =  Direction.S;
                break;
            default:
                calcDirection = Direction.INIT;
        }

        return calcDirection;
    }


    public static Position Move(Position roverPosition) throws Exception {

        Position calcPosition;
        Integer x = 0;
        Integer y = 0;

        x = roverPosition.getX();
        y = roverPosition.getY();

        Direction direction = roverPosition.getDirection();

        switch (direction) {

            case N:
                calcPosition = new Position(x, y + 1, direction);
                break;
            case S:
                calcPosition = new Position(x, y - 1 , direction);
                break;
            case W:
                calcPosition = new Position(x - 1, y, direction);
                break;
            case E:
                calcPosition = new Position(x + 1, y, direction);
                break;
            default:
                throw new Exception();
        }

        return calcPosition;

    }
}
