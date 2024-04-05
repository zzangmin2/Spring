package config;

import daelim.spring_ch06.Calculator;
import aspect.ExeTimeAspect;
import daelim.spring_ch06.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppContext {

    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }

    @Bean
    public ExeTimeAspect exeTimeAspect(){
        return new ExeTimeAspect();
    }

}
