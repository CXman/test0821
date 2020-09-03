package com.example.test0821.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @ClassName TimeUtil
 * @Author Xbao
 * @date 2020.08.13 20:33
 */
public class TimeUtil {
    private static SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("YYYY-MM-dd");
    private static SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getTime(){
        Date date =  new Date();
        return DATE_FORMAT1.format(date);
    }
    public static String getAccurateTime(){
        Date date = new Date();
        return DATE_FORMAT2.format(date);
    }
    public static Date getDateTime(String time) throws ParseException {
        return DATE_FORMAT1.parse(time);
    }
}
