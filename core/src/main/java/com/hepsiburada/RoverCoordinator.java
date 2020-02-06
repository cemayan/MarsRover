package com.hepsiburada;

import com.hepsiburada.enums.Direction;
import com.hepsiburada.enums.RoverRotate;

import java.util.Currency;

public class RoverCoordinator {

    public static Direction ExecuteLeftRigthDirections(RoverRotate roverRotate, Direction direction) {

        try {
            Direction currDirection = Direction.INIT;

            switch (roverRotate) {
                case L:
                    currDirection =  RoverMoveAction.Left(direction);
                    break;
                case R:
                    currDirection =  RoverMoveAction.Right(direction);
                    break;
                default:
                    throw  new  Exception();
            }

            return  currDirection;
        }
        catch (Exception e){
            System.out.println(e);
            return Direction.INIT;
        }
    }


    public static Position ExecuteMove(Plateau plateau,Position position) throws Exception {

        Position currPosition = RoverMoveAction.Move(position);

        if( currPosition.getX()  > plateau.getX()   || currPosition.getY() > plateau.getY()) {
            System.out.println("Current x: "+ currPosition.getX() + " " + "Current y: "+ currPosition.getY());
            throw  new Exception("Limits exceeded !!") ;
        }
        else {
            return  currPosition;
        }
    }
}
