package com.example.mobsoft.mobsoft_lab3.utils;

/**
 * Created by Android on 2017. 05. 03..
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private static Gson gson;

    static {
        gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
    }

    public static Gson getGson() {
        return gson;
    }
}
