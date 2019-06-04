package com.cto.explosive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zhangyongwei
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping
    public String index(){
        return "index";
    }

}
