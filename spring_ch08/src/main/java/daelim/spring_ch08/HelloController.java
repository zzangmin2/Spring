package daelim.spring_ch08;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false) String name){
        System.out.println("Hello Controller >>>>>>");
        model.addAttribute("greeting", "안녕하세요," + name);

        return "hello";
    }

}
