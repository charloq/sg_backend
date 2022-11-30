package com.siriolibanes.sg.util.model;

import java.util.Arrays;

public class Categorias {
    private static String categorias = "Mosquito,Premini,Mini,U13,U15,U17,Primera";

    public static String[] getCategorias() {
        String[] categoriasArray = categorias.split(",");
        Arrays.sort(categoriasArray);
        return categoriasArray;
    }
}
