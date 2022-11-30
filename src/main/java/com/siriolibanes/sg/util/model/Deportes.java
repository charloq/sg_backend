package com.siriolibanes.sg.util.model;

import java.util.Arrays;

public class Deportes {
    private static String deportes = "Basquet,Voley,Patinaje";

    public static String[] getDeportes() {
        String[] deportesArray = deportes.split(",");
        Arrays.sort(deportesArray);
        return deportesArray;
    }
}
