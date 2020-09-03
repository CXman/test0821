package com.example.test0821.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: V1.0
 * @author: 陈小宝
 * @className: ThymeLeafController
 * @packageName: com.example.test0821.controller
 * @description:
 * @data: 2020-08-25 11:24
 */
@Controller
public class ThymeLeafController {

    @RequestMapping("testleaf")
    public String test(ModelMap modelMap, HttpSession session){
        modelMap.addAttribute("protagonist","福尔摩斯");
        modelMap.addAttribute("supportingrole",Arrays.asList("花生","雪莉","女房东"));
        modelMap.addAttribute("dish","../static/images/meat.jpg");
        modelMap.addAttribute("age",13);
        Map<String,Object> map = new HashMap<>();
        map.put("ages",10);
        map.put("time",new Date());
        session.setAttribute("info",map);
        return "test";
    }
}
