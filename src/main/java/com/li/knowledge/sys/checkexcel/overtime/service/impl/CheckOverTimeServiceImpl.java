package com.li.knowledge.sys.checkexcel.overtime.service.impl;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.sys.checkexcel.overtime.model.dto.CheckOverTimeDTO;
import com.li.knowledge.sys.checkexcel.overtime.model.vo.CheckOverTimeVO;
import com.li.knowledge.sys.checkexcel.overtime.repository.CheckOverTimeRepository;
import com.li.knowledge.sys.checkexcel.overtime.service.CheckOverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
