package com.siriolibanes.sg.util.model;

import java.util.Arrays;

public class Sexos {
    private static String sexos = "Masculino,Femenino,No binario";

    public static String[] getSexos() {
        String[] sexosArray = sexos.split(",");
        Arrays.sort(sexosArray);
        return sexosArray;
    }
}
