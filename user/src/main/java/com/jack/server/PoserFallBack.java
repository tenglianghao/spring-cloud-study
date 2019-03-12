package com.jack.server;

import org.springframework.stereotype.Component;

@Component
public class PoserFallBack implements PowerServerClient {
    @Override
    public Object selectPower() {
        return "系统正在维护...";
    }
}
