package daelim.spring_ch04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class MemberListPrinter {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    @Qualifier("memberSummaryPrinter")
    private MemberPrinter memberPrinter;
/*

    public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
        this.memberDao = memberDao;
        this.memberPrinter = memberPrinter;

    }

 */

    public void printAll(){
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> memberPrinter.print(member));

    }

}
