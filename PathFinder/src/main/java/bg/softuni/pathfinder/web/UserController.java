package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.dto.UserLoginDto;
import bg.softuni.pathfinder.web.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/register")
    public String viewRegister(Model model) {
       model.addAttribute("registerData", new UserRegisterDto());
       model.addAttribute("levels", Level.values());
        return "register";
    }

    @PostMapping("users/register")
    public String doRegister(
            UserRegisterDto registerData,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    )
    {
//        if (bindingResult.hasErrors()) {
//            //handle error
//            redirectAttributes.addFlashAttribute("registerData", userRegisterDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.UserRegisterDto", bindingResult);
//
//            return "register";
//        }

        userService.register(registerData);
        return "redirect:/users/login";

    }

    @GetMapping("users/login")
    public ModelAndView viewLogin() {
        ModelAndView modelAndView=new ModelAndView("login");
        modelAndView.addObject("loginData", new UserLoginDto());
        return modelAndView;

    }
    @PostMapping("users/login")
    public  String login(UserLoginDto loginData) {
        System.out.println();
        return "login";
    }


}
