package com.nischal.jdbc.exception;

import com.nischal.jdbc.util.LogUtil;

public class ExceptionHandler {

    public static  void handle(ExceptionWrapper wrapper){

        try{
            wrapper.process();
        }
        catch(Exception e){
            LogUtil.exception(e);
        }
    }
}
