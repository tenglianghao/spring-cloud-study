package jack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/power")
public class PowerController {

    @RequestMapping("/selectPower")
    public Object power() {
        Map<String, Object> map = new HashMap<>();
        map.put("power2", 20);
        return map;
    }
}
