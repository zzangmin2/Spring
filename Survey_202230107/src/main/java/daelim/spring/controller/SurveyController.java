package daelim.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import daelim.spring.survey.SurveyRegisterService;
import daelim.spring.controller.SurveyCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyRegisterService surveyRegisterService;

    //[Get] 설문조사 폼
    @GetMapping("/surveyForm")
    public String handleSurvey(Model model) {
        System.out.println("surveyForm GET>>>>>>>>>>>>>>>>");
        model.addAttribute("surveyData", new SurveyCommand());
        return "survey/surveyForm";
    }

    //[Post] 설문조사 제출
    @PostMapping("/surveyForm")
    public String handleSubmitSurvey(@Valid @ModelAttribute("surveyData") SurveyCommand surveyCommand, Errors errors, Model model) {
        System.out.println("surveyForm POST>>>>>>>>>>>>>>>>");

        if (errors.hasErrors()) {
            System.out.println("Form has errors: " + errors.getAllErrors());
            return "survey/surveyForm";
        }

        try {
            surveyRegisterService.regist(surveyCommand);
            System.out.println("성공");
            model.addAttribute("message", "설문조사가 성공적으로 제출되었습니다!"); // 성공 메시지 추가
            return "survey/surveyComplete";
        } catch (Exception e) {
            e.printStackTrace();
            return "survey/surveyForm";
        }
    }

    //[Get] 설문조사 결과
    @GetMapping("/surveyComplete")
    public String handleSurveyCompleteGet() {
        System.out.println("surveyComplete GET>>>>>>>>>>>>>>>>");
        return "survey/surveyComplete";
    }

    //[Get]전체 설문조사 리스트
    @GetMapping("/surveyList")
    public String handleSurveyListGet(Model model) {
        System.out.println("surveyList GET>>>>>>>>>>>>>>>>");
        System.out.println( surveyRegisterService.selectAllSurveys());
        model.addAttribute("list", surveyRegisterService.selectAllSurveys());
        return "survey/surveyList";
    }

}
