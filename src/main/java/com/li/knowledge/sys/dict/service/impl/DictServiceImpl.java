package com.li.knowledge.sys.dict.service.impl;

import com.li.knowledge.sys.dict.repository.DictRepositroy;
import com.li.knowledge.sys.dict.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: knowledge
 * @description: 字典业务层实现类
 * @author: lifh
 * @create: 2020-08-07 15:48
 **/
@Slf4j
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictRepositroy dictRepositroy;

}
