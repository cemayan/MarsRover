package com.hepsiburada;

import com.hepsiburada.interfaces.IPlateauService;
import com.hepsiburada.interfaces.IRoverMoveService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


public class AppTest
{

    private static IRoverMoveService roverMoveService = new RoverMoveService();
    private static IPlateauService plateauService = new PlateauService();


    @Test
    public void testResult()
    {

        Plateau plateau = new Plateau(5,5);
        String direction = "1 2 N";
        String commands = "LMLMLMLMM";

        String response =  roverMoveService.move(plateau,direction,commands);
        assertEquals(response,"1 3 N");

    }


    @Test
    public void testFailDirection()
    {

        Plateau plateau = new Plateau(5,5);
        String direction = "1 2 F";
        String commands = "LMLMLMLMM";

        String response =  roverMoveService.move(plateau,direction,commands);
        assertEquals(response,"Error!");

    }

    @Test
    public void testFailCommand()
    {

        Plateau plateau = new Plateau(5,5);
        String direction = "1 2 N";
        String commands = "LMLMLMLMMS";

        String response =  roverMoveService.move(plateau,direction,commands);
        assertEquals(response,"Error!");

    }


    @Test
    public void testTypeCheck()
    {
        plateauService.createPlateau("5 5");

        Plateau plateau = new Plateau(5,5);

        assertEquals(plateauService.getPlateau().getX(), plateau.getX());
        assertEquals(plateauService.getPlateau().getY(), plateau.getY());

    }


}
