package jack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PowerServerApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(PowerServerApplication2.class, args);
    }
}
