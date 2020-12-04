package com.li.knowledge.utils.date;

import com.li.knowledge.common.data.AnnualYearHoliday;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: knowledge
 * @description: 加班核对时间工具类
 * @author: lifh
 * @create: 2020-09-08 11:22
 **/
public class OverTimeDateUtils {

    /**
     * @Description: 判断时间A是否>=时间B
     * @Param:  sub 提交日期
     * @Param:  sta 开始日期
     * @return:  大于等于 true 小于为 false
     * @Author: lifh
     * @Date: 2020/9/7 0007 下午 3:52
     */
    public static boolean isADYB(Date sub , Date sta){
        return sub.getTime() >= sta.getTime();
    }

    /**
     * @Description: 判断提交日期是否>=开始日期
     * @Param:  sub 提交日期
     * @Param:  sta 开始日期
     * @return:  大于等于 true 小于为 false
     * @Author: lifh
     * @Date: 2020/9/7 0007 下午 3:52
     */
    public static boolean isSubmitDYStartTime(Date sub , Date sta){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String substr = sdf.format(sub);
        String stastr = sdf.format(sta);
        Date subdate = null;
        Date stadate = null;
        try {
            subdate = sdf.parse(substr);
            stadate = sdf.parse(stastr);
        }catch (Exception e){

        }
        return subdate.getTime() >= stadate.getTime();
    }

    /**
     * @Description: 判断两个时间的差是否大于h小时
     * @Param:  startDate 开始时间
     * @Param:  endDate 结束时间
     * @return:  大于等于h个小时 true 小于为 false
     * @Author: lifh
     * @Date: 2020/9/7 0007 下午 3:52
     */
    public static boolean isTimeQuantum(Date startDate , Date endDate ,int h){
        long hh = h * 3600 * 1000;
        long startSs = startDate.getTime();
        long endSs = endDate.getTime();
        return (endSs-startSs) >= hh;
    }

    /**
     * @Description: 判断当前时间是否大于下午18:00点;
     * @Param:  时间
     * @return:  true 大于 false 不大于
     * @Author: lifh
     * @Date: 2020/9/7 0007 下午 4:03
     */
    public static boolean isDateSixH(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return Integer.valueOf(sdf.format(date)) >= 18;
    }
    
    /** 
    * @Description: 判断签入时间是否在九点半或之前
    * @Param:  date
    * @return:  如果 <= 9:30 返回true else 返回false
    * @Author: lifh
    * @Date: 2020/9/8 0008 下午 2:57
    */ 
    public static boolean isCheckinNine(Date date){
        Integer nine = 34200;
        SimpleDateFormat hh = new SimpleDateFormat("HH");
        SimpleDateFormat dd = new SimpleDateFormat("mm");
        SimpleDateFormat ss = new SimpleDateFormat("ss");
        Integer h = Integer.valueOf(hh.format(date));
        Integer d = Integer.valueOf(dd.format(date));
        Integer s = Integer.valueOf(ss.format(date));
        Integer sum = h*3600+d*60+s;
        return sum<=nine;
    }

    /**
     * @Description: 判断签入时间是否在6点之后
     * @Param: date
     * @return: 如果 >= 6:00 返回true else 返回false
     * @Author: lifh
     * @Date: 2020/9/8 0008 下午 2:57
     */
    public static boolean isCheckinSix(Date date){
        Integer six = 21600;
        SimpleDateFormat hh = new SimpleDateFormat("HH");
        SimpleDateFormat dd = new SimpleDateFormat("mm");
        SimpleDateFormat ss = new SimpleDateFormat("ss");
        Integer h = Integer.valueOf(hh.format(date));
        Integer d = Integer.valueOf(dd.format(date));
        Integer s = Integer.valueOf(ss.format(date));
        Integer sum = h*3600+d*60+s;
        return sum>=six;
    }

    /**
     * @Description: 判断时间是否为节假日
     * @Param:  date
     * @return:  是返回true 不是返回false
     * @Author: lifh
     * @Date: 2020/9/8 0008 下午 2:25
     */
    public static boolean isHoliday(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(String holiday : AnnualYearHoliday.getAnnualYearHoliday()){
            if(holiday.equals(sdf.format(date))){
                return true;
            }
        }
        return false;
    }

}
