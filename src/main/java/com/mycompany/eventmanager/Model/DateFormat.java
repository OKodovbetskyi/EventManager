package com.mycompany.eventmanager.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Check if data entered in text field Date is in Valid format.
public class DateFormat {
    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
