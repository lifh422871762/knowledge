package com.li.knowledge.sys.checkexcel.overtime.service.impl;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.common.model.Result;
import com.li.knowledge.sys.checkexcel.overtime.model.CheckOverTime;
import com.li.knowledge.sys.checkexcel.overtime.model.dto.CheckOverTimeDTO;
import com.li.knowledge.sys.checkexcel.overtime.model.vo.CheckOverTimeVO;
import com.li.knowledge.sys.checkexcel.overtime.repository.CheckOverTimeRepository;
import com.li.knowledge.sys.checkexcel.overtime.service.CheckOverTimeService;
import com.li.knowledge.utils.date.OverTimeDateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: knowledge
 * @description: 核对加班业务层实现类
 * @author: lifh
 * @create: 2020-09-04 14:31
 **/
@Service
public class CheckOverTimeServiceImpl implements CheckOverTimeService {

    @Autowired
    private CheckOverTimeRepository checkOverTimeRepository;

    @Override
    public LayuiTableResult<CheckOverTimeVO> search(CheckOverTimeDTO checkOverTimeDTO) {
        LayuiTableResult<CheckOverTimeVO> tableResult = new LayuiTableResult<>();
        List<CheckOverTimeVO> checkOverTimeVOList = checkOverTimeRepository.search(checkOverTimeDTO);
        int total = checkOverTimeRepository.countByModel(checkOverTimeDTO);
        tableResult.setCode(0);
        tableResult.setMsg("success");
        tableResult.setCount(total);
        tableResult.setData(checkOverTimeVOList);
        return tableResult;
    }

    @Override
    public Result insert(List<CheckOverTimeDTO> checkOverTimeDTOList) {
        if(null == checkOverTimeDTOList || checkOverTimeDTOList.size() <= 0){
            return new Result(false,"导入数据异常，数据列表为空！");
        }
        List<CheckOverTime> list = new ArrayList<>();
        computedCheckOverTime(checkOverTimeDTOList);
        for(CheckOverTimeDTO checkOverTimeDTO :checkOverTimeDTOList){
            CheckOverTime checkOverTime = new CheckOverTime();
            BeanUtils.copyProperties(checkOverTimeDTO,checkOverTime);
            list.add(checkOverTime);
        }
        try {
            checkOverTimeRepository.saveAll(list);
            return new Result(true,"，导入数据成功");
        }catch (Exception e) {
            return new Result(false,"，导入数据失败");
        }
    }


    /**
    * @Description: 核对加班判断逻辑
    * @Param:  核对前的数据
    * @Author: lifh
    * @Date: 2020/9/8 0008 下午 4:10
    */
    public void computedCheckOverTime(List<CheckOverTimeDTO> checkOverTimeDTOList){
        for(CheckOverTimeDTO checkOverTimeDTO : checkOverTimeDTOList){
            if(null == checkOverTimeDTO.getDno() || "".equals(checkOverTimeDTO.getDno())){
                continue;
            }
            //1，加班单【提交日期】必须 >= 【开始日期】
            if(!OverTimeDateUtils.isSubmitDYStartTime(checkOverTimeDTO.getSubmitTime(),checkOverTimeDTO.getStartTime())){
                checkOverTimeDTO.setStatus("异常");
                checkOverTimeDTO.setStatusMessage("提交日期 < 开始日期!");
                continue;
            }
            //2，加班单必须有【签入】【签出】两个日期
            if(null == checkOverTimeDTO.getCheckInTime() || null == checkOverTimeDTO.getCheckOutTime()){
                checkOverTimeDTO.setStatus("异常");
                checkOverTimeDTO.setStatusMessage("没有签入或签出时间!");
                continue;
            }
            //3，加班单【开始日期】必须 >= 【签入】
            if(!OverTimeDateUtils.isSubmitDYStartTime(checkOverTimeDTO.getStartTime(),checkOverTimeDTO.getCheckInTime())){
                checkOverTimeDTO.setStatus("异常");
                checkOverTimeDTO.setStatusMessage("开始时间 < 签入时间!");
                continue;
            }
            //4，加班单【结束日期】 必须 <= 【签出】
            if(!OverTimeDateUtils.isSubmitDYStartTime(checkOverTimeDTO.getCheckOutTime(),checkOverTimeDTO.getEndTime())){
                checkOverTimeDTO.setStatus("异常");
                checkOverTimeDTO.setStatusMessage("结束时间 > 签出时间!");
                continue;
            }
            //如果是工作日需要判断一下条件。
            if(!OverTimeDateUtils.isHoliday(checkOverTimeDTO.getStartTime())){
                //5，加班单【签入】必须 <= “9:30”
                if(!OverTimeDateUtils.isCheckinNine(checkOverTimeDTO.getCheckInTime())){
                    if(!OverTimeDateUtils.isCheckinSix(checkOverTimeDTO.getCheckInTime())){
                        checkOverTimeDTO.setStatus("警告");
                        checkOverTimeDTO.setStatusMessage("签入时间疑似不正常请查看!");
                        continue;
                    }
                    checkOverTimeDTO.setStatus("异常");
                    checkOverTimeDTO.setStatusMessage("签入时间 > 9:30!");
                    continue;
                }
                //6，加班单【开始日期】必须在“18:00”之后的时间
                if(!OverTimeDateUtils.isDateSixH(checkOverTimeDTO.getStartTime())){
                    checkOverTimeDTO.setStatus("异常");
                    checkOverTimeDTO.setStatusMessage("开始日期 < 18:00!");
                    continue;
                }
                //7，加班单【开始日期】-【签入】必须 >= 9h。
                if(!OverTimeDateUtils.isTimeQuantum(checkOverTimeDTO.getStartTime(),checkOverTimeDTO.getCheckInTime(),9)){
                    checkOverTimeDTO.setStatus("异常");
                    checkOverTimeDTO.setStatusMessage("开始日期 - 签入时间 < 9h!");
                    continue;
                }
            }
            //8，加班单【签出】-【签入】必须 >= 4h
            if(!OverTimeDateUtils.isTimeQuantum(checkOverTimeDTO.getCheckOutTime(),checkOverTimeDTO.getCheckInTime(),4)){
                checkOverTimeDTO.setStatus("异常");
                checkOverTimeDTO.setStatusMessage("开始日期 - 签入时间 < 9h!");
                continue;
            }
        }
    }
}
