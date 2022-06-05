package com.webservice.app.helpers;

public class StringHelper {
    public static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String getTurnoPalabra(char turno) {
        String turnoPalabra = "";
        switch (turno) {
            case 'M':
                turnoPalabra = "Mañana";
            case 'T':
                turnoPalabra = "Tarde";
            case 'N':
                turnoPalabra = "Noche";
            default:
                turnoPalabra = "";
        }
        return turnoPalabra;
    }
}
