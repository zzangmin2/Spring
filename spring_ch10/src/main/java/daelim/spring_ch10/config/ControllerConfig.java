package daelim.spring_ch10.config;

import daelim.spring_ch10.controller.HelloController;
import daelim.spring_ch10.controller.RegisterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Bean
    public HelloController helloController(){
        return new HelloController();
    }

    @Bean
    public RegisterController registerController(){
        return new RegisterController();
    }
}
