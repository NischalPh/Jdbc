package com.nischal.jdbc.builder;

import com.nischal.jdbc.response.Response;

public class ResponseBuilder {

    public static Response success(Object object, String message){

      return  Response.builder().success(true).data(object).message(message).build();
    }

    public static Response success(Object object){

        return Response.builder().success(true).data(object).build();
    }

    public static Response success(String message){
        return Response.builder().success(true).message(message).build();
    }

    public static Response failure(String message){
        return Response.builder().success(false).message(message).build();
    }
}
