package com.li.knowledge.sys.checkexcel.overtime.repository;


import com.li.knowledge.sys.checkexcel.overtime.model.CheckOverTime;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: knowledge
 * @description: 核对加班持久层接口
 * @author: lifh
 * @create: 2020-09-04 14:31
 **/
public interface CheckOverTimeRepository extends CrudRepository< CheckOverTime , String> , CheckOverTimeRepositoryCustomr {
}
