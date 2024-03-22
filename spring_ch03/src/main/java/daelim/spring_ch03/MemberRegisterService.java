package daelim.spring_ch03;

import java.time.LocalDateTime;
import java.util.Collection;

public class MemberRegisterService {

    // 1. 기존 방법
    // private MemberDao memberDao = new MemberDao();


    // 2. 생성자를 통해 의존 객체를 주입받음
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

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