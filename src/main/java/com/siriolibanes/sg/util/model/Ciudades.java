package com.siriolibanes.sg.util.model;

import java.util.Arrays;

public class Ciudades {
    private static String ciudades = "Deán Funes,Quilino,Tulumba";

    public static String[] getCiudades() {
        String[] ciudadesArray = ciudades.split(",");
        Arrays.sort(ciudadesArray);
        return ciudadesArray;
    }
}
