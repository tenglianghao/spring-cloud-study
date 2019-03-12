package com.jack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PowerController {

    @RequestMapping("/selectPower")
    public Object power(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("power", 10);
        if (name == null) {
            //throw new RuntimeException("参数name不能为空");//模拟微服务报错
            try {
                Thread.sleep(8000);// 模拟调用微服务超时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
