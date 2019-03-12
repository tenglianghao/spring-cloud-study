package com.jack.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用 fergn 调用其他微服务
 */
@FeignClient(name = "SERVER-POWER", fallback = PoserFallBack.class)
public interface PowerServerClient {

    @RequestMapping("/selectPower")
    Object selectPower();
}


