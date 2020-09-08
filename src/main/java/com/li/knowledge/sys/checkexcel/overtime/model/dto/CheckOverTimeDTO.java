package com.li.knowledge.sys.checkexcel.overtime.model.dto;

import com.li.knowledge.common.annotation.Excel;
import com.li.knowledge.common.model.PageTableDTO;
import lombok.Data;

import java.util.Date;

/**
 * @program: knowledge
 * @description: 核对加班接收页面参数实体类
 * @author: lifh
 * @create: 2020-09-04 14:31
 **/
@Data
public class CheckOverTimeDTO extends PageTableDTO {

    private String id;//主键

    @Excel(name = "单据号")
    private String dno;//单据号

    @Excel(name = "账号")
    private String account;//账号

    @Excel(name = "姓名")
    private String name;//姓名

    @Excel(name = "外包公司")
    private String outCompany;//外包公司

    @Excel(name = "加班类型")
    private String timeType;//加班类型

    @Excel(name = "开始日期")
    private Date startTime;//开始日期

    @Excel(name = "结束日期")
    private Date endTime;//结束日期

    @Excel(name = "加班小时数")
    private String timeHour;//加班小时数

    @Excel(name = "签入小时数")
    private String checkInHour;//签入小时数

    @Excel(name = "是否疑似异常")
    private String isError;//是否疑似异常

    @Excel(name = "签入时间")
    private Date checkInTime;//签入时间

    @Excel(name = "签出时间")
    private Date checkOutTime;//签出时间

    @Excel(name = "调休天数")
    private String ceaseDay;//调休天数

    @Excel(name = "结算天数")
    private String knotDay;//结算天数

    @Excel(name = "加班事由")
    private String reasonsOvertime;//加班事由

    @Excel(name = "加班项目")
    private String projectOvertime;//加班项目

    @Excel(name = "提交日期")
    private Date submitTime;//提交日期

    @Excel(name = "当前状态")
    private String currentStatus;//当前状态

    @Excel(name = "已审核人")
    private String activtiBy;//已审核人

    @Excel(name = "服务事业群")
    private String serviceGroup;//服务事业群

    @Excel(name = "外包类型")
    private String outsourceType;//外包类型

    @Excel(name = "所在城市")
    private String city;//所在城市

    private String status;//状态

    private String statusMessage;//状态中文编码

    @Override
    public String toString() {
        return "CheckOverTimeDTO{" +
                "id='" + id + '\'' +
                ", dno='" + dno + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", outCompany='" + outCompany + '\'' +
                ", timeType='" + timeType + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", timeHour='" + timeHour + '\'' +
                ", checkInHour='" + checkInHour + '\'' +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", ceaseDay='" + ceaseDay + '\'' +
                ", knotDay='" + knotDay + '\'' +
                ", reasonsOvertime='" + reasonsOvertime + '\'' +
                ", projectOvertime='" + projectOvertime + '\'' +
                ", submitTime=" + submitTime +
                ", currentStatus='" + currentStatus + '\'' +
                ", activtiBy='" + activtiBy + '\'' +
                ", serviceGroup='" + serviceGroup + '\'' +
                ", outsourceType='" + outsourceType + '\'' +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
