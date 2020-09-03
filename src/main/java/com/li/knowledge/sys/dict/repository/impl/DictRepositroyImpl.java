package com.li.knowledge.sys.dict.repository.impl;

import com.li.knowledge.sys.dict.repository.DictRepositroyCustomr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program: knowledge
 * @description: 字典持久层实现类
 * @author: lifh
 * @create: 2020-08-17 15:50
 **/
@Repository
public class DictRepositroyImpl  implements DictRepositroyCustomr {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
