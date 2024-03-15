package daelim.spring_ch02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //해당 클래스가 Bean구성 Class임을 알려줌
public class AppContext {

    @Bean //greeter를 Bean객체로 생성. 즉 외부 라이브러리를 Bean으로 만들어줌
    public Greeter greeter(){
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕하세요!");
        return g;
    }


}
