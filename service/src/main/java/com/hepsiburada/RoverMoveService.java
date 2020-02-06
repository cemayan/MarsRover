package com.hepsiburada;

import com.hepsiburada.enums.Direction;
import com.hepsiburada.enums.RoverRotate;
import com.hepsiburada.interfaces.IRoverMoveService;

import java.util.*;

public class RoverMoveService implements IRoverMoveService {

    public String move(Plateau plateau,String roverPosition, String roverCommand) {

        try{
            Integer x =  Integer.parseInt(roverPosition.split(" ")[0]);
            Integer y =  Integer.parseInt(roverPosition.split(" ")[1]);
            Direction direction = Direction.valueOf(roverPosition.split(" ")[2]);

            Queue<Character> queue = Utils.createQueue(roverCommand);
            Iterator iterator  = queue.iterator();
            Integer counter = 0;

            Direction currDirection = direction;
            Position currPosition = new Position(x, y, direction);

            while (iterator.hasNext()) {
                String str_command = Character.toString((Character) iterator.next());
                RoverRotate roverRotate = RoverRotate.valueOf(str_command);

                if(str_command.equals("M")){
                    if(counter.equals(0)) {
                        currPosition =  RoverCoordinator.ExecuteMove(plateau ,new Position(x,y,direction));
                    }
                    else {
                        currPosition =  RoverCoordinator.ExecuteMove(plateau, new Position(currPosition.getX(), currPosition.getY() ,currDirection));
                    }
                }
                else {

                    if(counter.equals(0)) {
                        currDirection = RoverCoordinator.ExecuteLeftRigthDirections(roverRotate, direction);
                    }
                    else {
                        currDirection = RoverCoordinator.ExecuteLeftRigthDirections(roverRotate, currDirection);
                    }
                }

                counter++;
            }

            return  currPosition.toString();
        }
        catch (Exception e) {
            System.out.println(e);
            return "Error!";
        }

    }
}
