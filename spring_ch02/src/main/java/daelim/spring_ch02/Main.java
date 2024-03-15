package daelim.spring_ch02;

import java.lang.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    //psvm (intelliJ)
    public static void main(String[] args) {

        //ApplicationContext -> 스프링 컨테이너. 메시지, 프로필, 환경변수 등을 처리할 수 있는 기능을 추가로 정의
        //AnnotationConfigApplicationContext -> configration 어노테이션으로 설정된 클래스를 가져옴
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter g = ctx.getBean("greeter", Greeter.class);
        String msg = g.greet("spring");
        System.out.println(msg);

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g == g2); //true
        // 별도 설정을 하지 않을 경우 한 개의 빈 객체만을 생성
        ctx.close();
    }

}
