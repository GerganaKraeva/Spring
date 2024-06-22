package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.AddRecipeDto;
import com.bonappetit.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final UserSession userSession;

    public RecipeController(RecipeService recipeService, UserSession userSession) {
        this.recipeService = recipeService;
        this.userSession = userSession;
    }

    @ModelAttribute("recipeData")
    public AddRecipeDto recipeData() {
        return  new AddRecipeDto();
    }

    @GetMapping("/recipe-add")
    public String addRecipe() {
        if(!userSession.isLoggedIn()) {
            return "redirect:/";
        }
        return "recipe-add";
    }

    @PostMapping("/recipe-add")
    public  String doAddRecipe(
            @Valid AddRecipeDto data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if(!userSession.isLoggedIn()) {
            return "redirect:/";
        }
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("recipeData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.recipeData", bindingResult);

            return "redirect:/recipe-add";
        }
        boolean success = recipeService.create(data);

        if(!success) {
            //duplicate name
            redirectAttributes.addFlashAttribute("recipeData", data);
            return "redirect:/recipe-add";
        }

        return "redirect:/home";
    }

    @PostMapping("/add-to-favourites/{recipeId}")
    public String addToFavourites(@PathVariable long recipeId){

        if(!userSession.isLoggedIn()) {
            return "redirect:/";

        }
        recipeService.addToFavourites(userSession.id(),recipeId);
        return "redirect:/home";
    }
}
