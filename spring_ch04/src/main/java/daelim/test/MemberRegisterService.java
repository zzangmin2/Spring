package daelim.test;

import daelim.spring_ch04.DuplicationMemberException;
import daelim.spring_ch04.Member;
import daelim.spring_ch04.MemberDao;
import daelim.spring_ch04.RegistRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;

@Component
public class MemberRegisterService {

    // 1. 기존 방법
    // private MemberDao memberDao = new MemberDao();


    // 2. 생성자를 통해 의존 객체를 주입받음
    @Autowired
    private MemberDao memberDao;

    /*
    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

     */

    public void regist(RegistRequest req){
        // 1. 이메일로 회원 데이터 조회
        Member member = memberDao.selectByEmail(req.getEmail());

        // 2. member != null : 이미 이메일을 가진 회원이 존재한다면
        // Exception 발생
        if(member != null){
            throw new DuplicationMemberException("Duplication Email: " + req.getEmail());

        }

        // 3.신규 회원 등록
        memberDao.insert(new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()));
    }
    public void selectAll(){
        Collection<Member> members = memberDao.selectAll();
        for(Member member:members){
            System.out.println(member.getId() + ":" + member.getName() + "(" + member.getEmail() + ")");
        }
    }

}