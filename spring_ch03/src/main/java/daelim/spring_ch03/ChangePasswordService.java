package daelim.spring_ch03;

public class ChangePasswordService {
    private MemberDao memberDao;

    //setter 메소드를 통해 의존 주입
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void changePassword(String email, String oldPassword, String newPassword){

        //1. 이메일로 회원 조회
        Member member = memberDao.selectByEmail(email);
        if(member == null){
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);

    }
}
