package com.li.knowledge.common.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: knowledge
 * @description: 全年节假日表数据
 * @author: lifh
 * @create: 2020-09-08 14:03
 **/
public class AnnualYearHoliday {

    /**
    * @Description: 获取2020年9月份到2020年12月份，节假日时间。
    * @return:  时间字符串
    * @Author: lifh
    * @Date: 2020/9/8 0008 下午 2:11
    */
    public static List<String> getAnnualYearHoliday(){
        List<String> holidayList = new ArrayList<>();
        //2020年9月节假日
        holidayList.add("2020-09-05");
        holidayList.add("2020-09-06");
        holidayList.add("2020-09-12");
        holidayList.add("2020-09-13");
        holidayList.add("2020-09-19");
        holidayList.add("2020-09-20");
        holidayList.add("2020-09-26");
        //2020年10月节假日
        holidayList.add("2020-10-01");
        holidayList.add("2020-10-02");
        holidayList.add("2020-10-03");
        holidayList.add("2020-10-04");
        holidayList.add("2020-10-05");
        holidayList.add("2020-10-06");
        holidayList.add("2020-10-07");
        holidayList.add("2020-10-08");
        holidayList.add("2020-10-11");
        holidayList.add("2020-10-17");
        holidayList.add("2020-10-18");
        holidayList.add("2020-10-24");
        holidayList.add("2020-10-25");
        holidayList.add("2020-10-31");
        //2020年11月节假日
        holidayList.add("2020-11-01");
        holidayList.add("2020-11-07");
        holidayList.add("2020-11-08");
        holidayList.add("2020-11-14");
        holidayList.add("2020-11-15");
        holidayList.add("2020-11-21");
        holidayList.add("2020-11-22");
        holidayList.add("2020-11-28");
        holidayList.add("2020-11-29");
        //2020年12月节假日
        holidayList.add("2020-12-05");
        holidayList.add("2020-12-06");
        holidayList.add("2020-12-12");
        holidayList.add("2020-12-13");
        holidayList.add("2020-12-19");
        holidayList.add("2020-12-20");
        holidayList.add("2020-12-26");
        holidayList.add("2020-12-27");
        return holidayList;
    }

}
