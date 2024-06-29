package bg.softuni.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }

    @PostMapping("/test-result")
    public String test(@RequestParam String username,
                       Model model){
        model.addAttribute("username",username);
        return "hello";
    }
}
