package com.market.helper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class Helper {

    public Timestamp convertDatetimeToTimestamp(String datetime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = null;
        try {
            Date parsedDate = dateFormat.parse(datetime);
            Timestamp time = new Timestamp(parsedDate.getTime());
            timestamp=time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp == null ? Timestamp.valueOf(LocalDateTime.now()) : timestamp;
    }
}
