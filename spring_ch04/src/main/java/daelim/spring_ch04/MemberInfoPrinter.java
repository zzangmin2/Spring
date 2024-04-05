package daelim.spring_ch04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("memberInfoPrinter")
public class MemberInfoPrinter {

    //@Autowired
    private MemberDao memberDao;
    //@Autowired
    private MemberPrinter memberPrinter;


    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    @Qualifier("memberPrinter")
    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }

    public void printMember(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음");
            return;
        }
        memberPrinter.print(member);
    }

}
