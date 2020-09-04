package com.li.knowledge.sys.checkexcel.overtime.service;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.sys.checkexcel.overtime.model.dto.CheckOverTimeDTO;
import com.li.knowledge.sys.checkexcel.overtime.model.vo.CheckOverTimeVO;

/**
 * @program: knowledge
 * @description: 核对加班业务层接口
 * @author: lifh
 * @create: 2020-09-04 14:31
 **/
public interface CheckOverTimeService {

    /**
     * @Description: 查询加班核对数据集合列表
     * @Param: userDTO
     * @return: 核对加班集合
     * @Author: lifh
     * @Date: 2020/9/4 0007 下午 2:58
     */
    LayuiTableResult<CheckOverTimeVO> search(CheckOverTimeDTO checkOverTimeDTO);
}
