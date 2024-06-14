package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.dto.UserLoginDto;
import bg.softuni.pathfinder.web.dto.UserRegisterDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String viewRegister(Model model) {
       model.addAttribute("registerData", new UserRegisterDto());
       model.addAttribute("levels", Level.values());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(
            UserRegisterDto userRegisterDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
//        if (bindingResult.hasErrors()) {
//            //handle error
//            redirectAttributes.addFlashAttribute("registerData", userRegisterDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.UserRegisterDto", bindingResult);
//
//            return "register";
//        }

        userService.register(userRegisterDto);
        return "redirect:/users/login";

    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";

    }
    @PostMapping("/login")
    public  String login(UserLoginDto userLoginDto) {
        return "login";
    }


}
