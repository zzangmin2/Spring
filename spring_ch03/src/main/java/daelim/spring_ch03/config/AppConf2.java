package daelim.spring_ch03.config;


import daelim.spring_ch03.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf2 {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberPrinter memberPrinter;

    //MemberDao -> getBean("MemberDao")

    @Bean
    public MemberRegisterService memberRegisterService(){
        return new MemberRegisterService(memberDao);
    }

    @Bean
    public ChangePasswordService changePasswordService(){
        ChangePasswordService changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
        return changePasswordService;
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter memberListPrinter(){
        return new MemberListPrinter(memberDao, memberPrinter());
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
        MemberInfoPrinter  memberInfoPrinter = new MemberInfoPrinter();
        memberInfoPrinter.setMemberDao(memberDao);
        memberInfoPrinter.setMemberPrinter(memberPrinter());
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