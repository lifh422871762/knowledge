package com.li.knowledge.sys.dict.controller;

import com.li.knowledge.sys.BaseController;
import com.li.knowledge.sys.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: knowledge
 * @description: 字典控制层
 * @author: lifh
 * @create: 2020-08-17 15:47
 **/
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;




}
