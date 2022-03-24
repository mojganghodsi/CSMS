package com.hastobe.csms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/***
 * Interface in order to convert String to Date
 */
public interface DateConverter {
    /***
     * convert String to Date
     * @param dateInString
     * @return Date, converted string input
     */
    default Date stringToDate(String dateInString){
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = inputFormat.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
