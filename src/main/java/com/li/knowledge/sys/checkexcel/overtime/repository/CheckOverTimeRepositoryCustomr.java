package com.li.knowledge.sys.checkexcel.overtime.repository;

import com.li.knowledge.sys.checkexcel.overtime.model.dto.CheckOverTimeDTO;
import com.li.knowledge.sys.checkexcel.overtime.model.vo.CheckOverTimeVO;

import java.util.List;

/**
 * @program: knowledge
 * @description: 核对加班持久层自定义接口
 * @author: lifh
 * @create: 2020-09-04 14:31
 **/
public interface CheckOverTimeRepositoryCustomr {
    
    /** 
    * @Description: 查询核对加班总条数
    * @Param:  checkOverTimeDTO 查询条件实体
    * @return:  返回核对加班结果集合
    * @Author: lifh
    * @Date: 2020/9/4 0004 下午 3:03
    */ 
    List<CheckOverTimeVO> search(CheckOverTimeDTO checkOverTimeDTO);

    /**
    * @Description: 查询核对加班总条数
    * @Param:  checkOverTimeDTO查询条件
    * @return:  返回核对加班总条数
    * @Author: lifh
    * @Date: 2020/9/4 0004 下午 3:03
    */
    int countByModel(CheckOverTimeDTO checkOverTimeDTO);
}
