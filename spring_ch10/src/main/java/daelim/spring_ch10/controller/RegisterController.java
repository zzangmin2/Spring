package daelim.spring_ch10.controller;

import daelim.spring_ch10.DuplicationMemberException;
import daelim.spring_ch10.MemberRegisterService;
import daelim.spring_ch10.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {


    @Autowired
    private MemberRegisterService memberRegisterService;

//    @GetMapping("/main")
//    public String main(){
//        return "main";
//    }

    @GetMapping("/register/step1")
    public String handleStep1(){
        System.out.println("STEP 1 >>>>>>>>>>>>>>>>");
        return "register/step1";
    }

    @GetMapping("/register/step2")
    public String handleStep2Get() {
        System.out.println("[GET] step 2 >>>>>>>>>>");
//        return "redirect:/register/step1";
        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String handleStep2(@RequestParam(
            value="agree", defaultValue = "false"
    ) Boolean agree, Model model){
        System.out.println("STEP 2 >>>>>>>>>>>>>>>>");
        if(!agree){
            return "register/step1";
        }
        model.addAttribute("formData", new RegisterRequest());
        return "register/step2";
    }

    @PostMapping("/register/step3")
    public String handleStep3(@Valid RegisterRequest registerRequest, Errors errors){
        System.out.println("[POST] step 3 >>>>>>>>>>");
//        System.out.println("email:" + registerRequest.getEmail());
//        System.out.println("name:" + registerRequest.getName());

//        new RegisterRequestValidator().validate(registerRequest, errors);
//        System.out.println("hasErrors() :" + errors.hasErrors());

        if(errors.hasErrors()) {
            return "register/step2";
        }

        //service 로직 처리
        try{
            memberRegisterService.regist(registerRequest);
            System.out.println("성공");
            return "register/step3";

        }catch(DuplicationMemberException ex){
//            ex.printStackTrace();
            errors.rejectValue("email", "duplicate");
            return "register/step2";
        }
    }
}
