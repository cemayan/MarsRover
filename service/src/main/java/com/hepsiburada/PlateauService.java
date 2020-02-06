package com.hepsiburada;

import com.hepsiburada.interfaces.IPlateauService;

public class PlateauService  implements IPlateauService {

    private Plateau plateau;

    public void createPlateau(String gridSize) {

        Integer x =  Integer.parseInt(gridSize.split(" ")[0]);
        Integer y =  Integer.parseInt(gridSize.split(" ")[1]);
        plateau = new Plateau(x, y);
    }

    public Plateau getPlateau() {
        return plateau;
    }

}
