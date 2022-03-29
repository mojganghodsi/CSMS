package com.hastobe.csms.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateConverter {
    static String getLocalDateTimeAsString ( ){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }
}
