package com.li.knowledge.sys.checkexcel.overtime.controller;

import com.li.knowledge.common.model.LayuiTableResult;
import com.li.knowledge.sys.checkexcel.overtime.model.dto.CheckOverTimeDTO;
import com.li.knowledge.sys.checkexcel.overtime.model.vo.CheckOverTimeVO;
import com.li.knowledge.sys.checkexcel.overtime.service.CheckOverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: knowledge
 * @description: 核对加班控制类
 * @author: lifh
 * @create: 2020-09-04 14:31
 **/
@RestController
@RequestMapping(value = "/checkOverTime")
public class CheckOverTimeController {

    @Autowired
    private CheckOverTimeService checkOverTimeService;

    /**
     * @Description: 查询加班核对数据集合列表
     * @Param: userDTO
     * @return: 核对加班集合
     * @Author: lifh
     * @Date: 2020/9/4 0007 下午 2:58
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public LayuiTableResult<CheckOverTimeVO> search(CheckOverTimeDTO checkOverTimeDTO) {
        return checkOverTimeService.search(checkOverTimeDTO);
    }

    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public void importExcel(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
    }

}
