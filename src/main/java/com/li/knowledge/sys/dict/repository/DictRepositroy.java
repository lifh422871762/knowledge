package com.li.knowledge.sys.dict.repository;

import com.li.knowledge.sys.dict.model.Dict;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: knowledge
 * @description: 字典持久层jpa接口
 * @author: lifh
 * @create: 2020-08-17 15:48
 **/
public interface DictRepositroy  extends CrudRepository<Dict,String>, DictRepositroyCustomr {

}
