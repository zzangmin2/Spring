package spring_ch07.main;

import chapter08.ChangePasswordService;
import chapter08.MemberNotFoundException;
import chapter08.WrongPasswordException;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForChangePassword {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ChangePasswordService changePasswordService = ctx.getBean("changePasswordService", ChangePasswordService.class);

        try {
            changePasswordService.changePassword("a@a.com","0000","1234");
            System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원 데이터가 존재하지 않습니다.");
        } catch (WrongPasswordException e) {
            System.out.println("암호가 올바르지 않습니다.");
        }
    }
}
