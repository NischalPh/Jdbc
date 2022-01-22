package com.nischal.jdbc.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JaksonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object){

        try {
            return objectMapper.writeValueAsString(object);
        }catch(Exception e){
         return "exception while conveting to json"+e.getMessage();
        }
    }
}
