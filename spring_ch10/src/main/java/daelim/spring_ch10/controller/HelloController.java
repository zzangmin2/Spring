package daelim.spring_ch10.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class HelloController {

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required = false) String name){
        model.addAttribute("greeting", "안녕하세요" + name);
        return "hello"; //WEB-INF/views/hello.jsp
    }

}
