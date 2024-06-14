package bg.softuni.pathfinder.web;

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
    @GetMapping("/register")
    public String viewRegister(Model model) {
       model.addAttribute("registerData", new UserRegisterDto());
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

        return "redirect:/users/login";

    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";

    }


}
