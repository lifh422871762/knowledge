package com.li.knowledge.sys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @RequestMapping("/login")
    public String login(String username, String password){
        System.out.println(username + "---------------" + password);
        return "success";
    }

}
