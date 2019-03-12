package com.jack.provider;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;

public class MyFallbackProvicer implements FallbackProvider {
    @Override
    public String getRoute() {
        // 指明对哪个微服务进行降级回退
        return "server-power";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        // 回退逻辑
        return null;
    }
}
