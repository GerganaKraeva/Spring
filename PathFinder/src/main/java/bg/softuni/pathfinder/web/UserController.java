package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.web.dto.UserRegisterDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;

@Controller
public class UserController {
    @GetMapping("users/register")
    public String viewRegister(Model model) {
       model.addAttribute("registerData", new UserRegisterDto());
        return "register";
    }

    @PostMapping("users/register")
    public String doRegister(@Valid UserRegisterDto userRegisterDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            //handle error
            redirectAttributes.addFlashAttribute("registerData", userRegisterDto);
            return "register";
        }

        return "redirect:/users/login";

    }

    @GetMapping("users/login")
    public String viewLogin() {
        return "login";

    }


}
