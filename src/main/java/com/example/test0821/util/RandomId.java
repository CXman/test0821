package com.example.test0821.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Description
 * @ClassName RandomId
 * @Author Xbao
 * @date 2020.08.14 14:59
 */
public class RandomId {
    public static String getRandomId(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String day = simpleDateFormat.format(date);
        Random random = new Random(System.currentTimeMillis());
        return day+(random.nextLong()+"").substring(1);
    }
}
