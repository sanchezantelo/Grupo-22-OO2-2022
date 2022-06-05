package com.webservice.app.helpers;

public class StringHelper {
    public static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
