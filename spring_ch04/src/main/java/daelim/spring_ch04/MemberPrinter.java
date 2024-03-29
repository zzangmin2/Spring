package daelim.spring_ch04;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {

    private DateTimeFormatter dateTimeFormatter;

    //@Autowired(required = false)
    @Autowired
    public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatter){
        if(dateTimeFormatter.isPresent()){
            this.dateTimeFormatter = dateTimeFormatter.get();
        }else{
            this.dateTimeFormatter = null;
        }

    }

    public void print(Member member){

        if(dateTimeFormatter == null){
        System.out.printf("회원정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n", member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else{
            System.out.printf("회원정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n", member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }
}
