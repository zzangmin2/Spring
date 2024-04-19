package spring_ch07.main;

import chapter08.Member;
import chapter08.MemberDao;
import config.AppConfig;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForMemberDao {

    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        memberDao = ctx.getBean("memberDao", MemberDao.class);
        selectAll();
        updateMember();
        insertMember();
    }

    private static void selectAll() {
        System.out.println("---- SelectAll() ----");
        int count = memberDao.count();
        System.out.println("total count : "+ count);

        List<Member>  members = memberDao.selectAll();
        for(Member m : members) {
            System.out.println(m.getId()+":"+m.getEmail()+":"+m.getName());
        }
    }

    private static void updateMember() {
        System.out.println("---- UpdateMember ----");
        Member member = memberDao.selectByEmail("a@a.com");
        String oldPw = member.getPassword();
        String newPw = Double.toHexString(Math.random());
        member.changePassword(oldPw, newPw);
        memberDao.update(member);
        System.out.println("changePassword : "+ oldPw +">>"+ newPw);
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
    private static void insertMember() {
        System.out.println("---- InsertMember ----");
        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member(prefix+"@test.com", prefix, prefix, LocalDateTime.now());
        memberDao.insert(member);
        System.out.println("insert : "+member.getId());
    }
}
