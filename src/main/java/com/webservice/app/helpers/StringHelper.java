package com.webservice.app.helpers;

public class StringHelper {
    public static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String getTurnoPalabra(char turno) {
        String turno_ = "";
        switch (turno) {
            case 'M':
                turno_ = "Mañana";
            case 'T':
                turno_ = "Tarde";
            case 'N':
                turno_ = "Noche";
            default:
                turno_ = "";
        }
        return turno_;
    }
}
