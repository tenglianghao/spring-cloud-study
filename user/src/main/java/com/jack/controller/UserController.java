package com.jack.controller;

import com.jack.server.PowerServerClient;
import com.jack.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PowerServerClient powerServerClient;

    /**
     * SERVER_POWER 这个url要根据 eureka 的application来定
     */
    private static final String SERVER_POWER ="http://SERVER-POWER";

    @RequestMapping("/all")
    public Object getAll() {
        List<Map<String, Object>> userList = new ArrayList<>();
        Map<String, Object> u1 = new HashMap<>();
        u1.put("name", "jack");
        u1.put("age", 25);
        userList.add(u1);
        return userList;
    }

    @RequestMapping("/power")
    @HystrixCommand(fallbackMethod = "getFeignPowerFallBack",threadPoolKey = "power",threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "2"),
            @HystrixProperty(name = "maxQueueSize",value = "1")
    })
    public R getPower() {
        System.out.println("使用 restTemplate 调用了微服务");
        return R.success("操作成功",
                restTemplate.getForObject(SERVER_POWER+"/selectPower",Object.class));
    }


    @RequestMapping("/getFeignPower.do")
    //@HystrixCommand(fallbackMethod = "getFeignPowerFallBack")
    public R getFeignPower() {
        // feign整合hystrix
        return R.success("操作成功", powerServerClient.selectPower());
    }

    /**
     * 降级方法，返回类型要跟原方法一致，最好不要写复杂逻辑
     * @see #getFeignPower()
     * @return
     */
    public R getFeignPowerFallBack() {
        return R.error("系统正在维护中，请稍后重试");
    }



}
