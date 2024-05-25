package daelim.spring.config;

import daelim.spring.controller.SurveyController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public SurveyController surveyController(){
        return new SurveyController();
    }
}
