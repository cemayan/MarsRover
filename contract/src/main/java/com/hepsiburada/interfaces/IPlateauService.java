package com.hepsiburada.interfaces;

import com.hepsiburada.Plateau;

public interface IPlateauService {
    void createPlateau(String gridSize);
    Plateau getPlateau();
}
