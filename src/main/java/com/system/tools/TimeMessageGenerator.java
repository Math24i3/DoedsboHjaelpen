package com.system.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeMessageGenerator {



    public String timeOfTheDay() {
        String message = "";
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;
        dateFormat.format(date);

    try {
        if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("00:00")) && dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("10:00")))
        {
            message = "godmorgen,";
        }else if (dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("10:01")) && dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("12:00"))){
            message = "God formiddag,";
        }else if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("12:01")) && dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("17:00"))){
            message = "God eftermiddag,";
        }else if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("17:01")) && dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("23:59"))){
            message = "God aften,";
        }
    }catch (ParseException e){
        e.printStackTrace();
    }
        return message;
    }
}
