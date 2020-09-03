package com.example.test0821.controller;

import com.woniu.starter.ExpressBirdsProperties;
import me.maiz.tool.KuaiDiNiaoQueryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: V1.0
 * @author: 陈小宝
 * @className: ExpressController
 * @packageName: com.example.test0821.controller
 * @description:
 * @data: 2020-08-24 22:47
 */
@RestController
public class ExpressController {

    @Autowired
    private KuaiDiNiaoQueryAPI kuaiDiNiaoQueryAPI;

    @GetMapping("expressquery")
    public String getAddr(String code,String no) throws Exception {
        return kuaiDiNiaoQueryAPI.getOrderTracesByJson(code,no);
    }
}
