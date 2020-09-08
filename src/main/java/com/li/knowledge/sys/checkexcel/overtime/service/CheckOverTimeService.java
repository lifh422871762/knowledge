package com.li.knowledge.sys.checkexcel.overtime.service;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.common.model.Result;
import com.li.knowledge.sys.checkexcel.overtime.model.dto.CheckOverTimeDTO;
import com.li.knowledge.sys.checkexcel.overtime.model.vo.CheckOverTimeVO;

import java.util.List;

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

    /** 
    * @Description: 插入导入的加班核对数据数据
    * @Param:  checkOverTimeDTOList 加班核对数据集合
    * @return: 操作信息
    * @Author: lifh
    * @Date: 2020/9/8 0008 上午 11:25
    */ 
    Result insert(List<CheckOverTimeDTO> checkOverTimeDTOList);
    
}
