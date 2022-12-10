package com.siriolibanes.sg.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String formatFecha(Date fecha, String patron) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patron);
        return simpleDateFormat.format(fecha);
    }
}
