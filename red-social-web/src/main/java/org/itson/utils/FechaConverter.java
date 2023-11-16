/**
* FechaConverter.java
* Jul 7, 2023 11:32:32 AM
*/ 

package org.itson.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FechaConverter {

    /**
     *
     */
    public FechaConverter(){

    }
    
    public static Calendar stringToCalendar(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateFormat.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
