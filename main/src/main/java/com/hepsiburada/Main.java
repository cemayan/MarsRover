package com.hepsiburada;

import com.hepsiburada.interfaces.IPlateauService;
import com.hepsiburada.interfaces.IRoverMoveService;

import java.util.Scanner;

public class Main
{
    private static IRoverMoveService roverMoveService = new RoverMoveService();
    private static IPlateauService plateauService = new PlateauService();

    public static void main( String[] args )
    {

        System.out.println("Pls type Grid Size:");
        Scanner in_gs = new Scanner(System.in);
        String gridSize = in_gs.nextLine();

        plateauService.createPlateau(gridSize);
        Plateau plateau = plateauService.getPlateau();


        Boolean newRover = true;

        StringBuilder sb = new StringBuilder();

        while (newRover) {

            System.out.println("Pls type rover position:");
            Scanner in_rp = new Scanner(System.in);
            String roverPosition = in_rp.nextLine();

            System.out.println("Pls type rover command:");
            Scanner in_rc = new Scanner(System.in);
            String roverCommand = in_rc.nextLine();


            System.out.println("Do you want to add a rover ?(Y/N)");
            Scanner in_nr = new Scanner(System.in);
            String nr = in_nr.nextLine();

            String response =  roverMoveService.move(plateau,roverPosition,roverCommand);
            sb.append(response + "\n");

            if(nr.equals("N")) {
                newRover = false;
            }

        }

        System.out.println(sb.toString());
    }
}
