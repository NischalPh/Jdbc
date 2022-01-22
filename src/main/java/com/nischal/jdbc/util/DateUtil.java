package com.nischal.jdbc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date formatDate(String date, String format) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(date);
    }

    public static java.sql.Date convertToSqlDate(Date utilDate){

        java.sql.Date sqlDate= null;
        if(utilDate!=null){
            sqlDate = new java.sql.Date(utilDate.getTime());
        }
        return sqlDate;
    }
}
