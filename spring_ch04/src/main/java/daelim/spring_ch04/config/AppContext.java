package daelim.spring_ch04.config;


import daelim.spring_ch04.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"daelim.spring_ch04", "daelim.test"})

//예외처리
//        , excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern = "daelim.spring_ch04\\..*Dao")) //정규표현식
//        , excludeFilters = @ComponentScan.Filter(type= FilterType.ASPECTJ, pattern = "daelim.spring_ch04.*Dao")) //aspectj

//        , excludeFilters = {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class) //ASSIGNABLE_TYPE
//        ,@ComponentScan.Filter(type= FilterType.ASPECTJ, pattern = "daelim.spring_ch04.*Service")})


public class AppContext {

    //MemberDao -> getBean("MemberDao")

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

/*
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
 */

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

/*
    @Bean
    public MemberListPrinter memberListPrinter(){
        //return new MemberListPrinter(memberDao(), memberPrinter());
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
        MemberInfoPrinter  memberInfoPrinter = new MemberInfoPrinter();
        //memberInfoPrinter.setMemberDao(memberDao());
        memberInfoPrinter.setMemberPrinter(memberPrinter2());
        return memberInfoPrinter;
    }
 */

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(2);
        versionPrinter.setMinorVersion(1);
        return versionPrinter;
    }

}