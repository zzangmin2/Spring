package daelim.spring_ch03.main;

import daelim.spring_ch03.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Assembler assembler = new Assembler();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //MemberDao memberDao = new MemberDao();

        while (true) {
            System.out.println("명령어를 입력하시오");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }

            if (command.startsWith("new")) {
                //회원등록
                processNewCommand(command.split(" ") );
                continue;
            }

            // 비밀번호 변경
            if(command.startsWith("change")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

        private static void processNewCommand(String[] arg ){
            if(arg.length != 5) {
                printHelp();
                return;
            }

            System.out.println(" >>>>>>>>>>>>>>>>>>>>> ");

            //MemberDao memberDao = new MemberDao();
            //MemberRegisterService memberRegisterService = new MemberRegisterService(memberDao);
            MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();

            RegistRequest registRequest = new RegistRequest();
            registRequest.setEmail(arg[1]);
            registRequest.setName(arg[2]);
            registRequest.setPassword(arg[3]);
            registRequest.setConfirmPassword(arg[4]);
            System.out.println(arg);

            if(!registRequest.isPasswordEqualToConfirmPassword()){
                System.out.println("암호와 확인이 일치하지 않습니다.");
                return;
            }

            try{
                memberRegisterService.regist(registRequest);
                System.out.println("회원 등록이 되었습니다.");
                memberRegisterService.selectAll();
            }catch(DuplicationMemberException e){
                System.out.println("이미 존재하는 이메일입니다.");
            }
    }

    private static void processChangeCommand(String[] arg){
        if(arg.length != 4){
            printHelp();
            return;
        }

        //ChangePasswordService changePasswordService = new ChangePasswordService();
        //changePasswordService.setMemberDao(memberDao);

        ChangePasswordService changePasswordService = assembler.getChangePasswordService();


        try{
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
        }catch (MemberNotFoundException e){
            System.out.println("존재하지 않는 이메일입니다.");
        }catch(WrongPasswordException e){
            System.out.println("암호가 일치하지 않습니다.");
        }
    }


    private static void printHelp(){
        System.out.println();
        System.out.println("잘못된 명령어입니다. 아래 명령어 사용법을 확인하세요");
        System.out.println(" new 이메일 이름 암호 암호확인");
        System.out.println(" change 이메일 현재암호 변경암호");
    }
}
