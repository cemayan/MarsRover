package com.hepsiburada.interfaces;

import com.hepsiburada.Plateau;

public interface IRoverMoveService {
    String move(Plateau plateau, String roverPosition, String roverCommand);
}
