package com.li.knowledge.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: knowledge
 * @description: 处理时间日期的转换工具类
 * @author: lifh
 * @create: 2020-08-13 17:43
 **/
public class DateUtils {

    /**
     * 将 yyyy-MM-dd  格式的字符串转换为Date类型
     * @param date
     * @return Date
     */
    public static Date parseDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

}
