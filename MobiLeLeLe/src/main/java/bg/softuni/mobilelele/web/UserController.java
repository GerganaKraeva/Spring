package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.UserRegistrationDto;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String doRegister(UserRegistrationDto userRegistrationDto) {
       userService.registerUser(userRegistrationDto);

        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }
}
