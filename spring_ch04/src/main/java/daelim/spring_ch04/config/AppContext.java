package daelim.spring_ch04.config;


import daelim.spring_ch04.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppContext {

    //MemberDao -> getBean("MemberDao")

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }


    @Bean
    public MemberRegisterService memberRegisterService(){
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePasswordService(){
        ChangePasswordService changePasswordService = new ChangePasswordService();
        // setter를 통해 직접 의존 주입하지 않아도 스프링이 @Autowired가 붙은 필드에 해당 타입으로 빈을 찾아서 주입한다.
   //     changePasswordService.setMemberDao(memberDao());
        return changePasswordService;
    }

    @Bean
    @Qualifier("memberPrinter")
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("memberSummaryPrinter")
    public MemberSummaryPrinter memberPrinter2(){
        return new MemberSummaryPrinter();
    }


    @Bean
    public MemberListPrinter memberListPrinter(){
        //return new MemberListPrinter(memberDao(), memberPrinter());
        return new MemberListPrinter();
    }
202
    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
        MemberInfoPrinter  memberInfoPrinter = new MemberInfoPrinter();
        //memberInfoPrinter.setMemberDao(memberDao());
        memberInfoPrinter.setMemberPrinter(memberPrinter2());
        return memberInfoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(2);
        versionPrinter.setMinorVersion(1);
        return versionPrinter;
    }

}