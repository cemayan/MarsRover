package com.hepsiburada;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Utils {

    public static Queue<Character> createQueue(String roverCommand) {

        Queue<Character> charsQueue = new LinkedList<Character>();

        for (char c : roverCommand.toCharArray()) {
            charsQueue.offer(c);
        }

        return  charsQueue;
    }

}
