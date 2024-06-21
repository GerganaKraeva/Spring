package com.bonappetit.controller;

import com.bonappetit.model.dto.AddRecipeDto;
import com.bonappetit.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ModelAttribute("recipeData")
    public AddRecipeDto recipeData() {
        return  new AddRecipeDto();
    }
    @GetMapping("/recipe-add")
    public String addRecipe() {
        return "recipe-add";
    }

    @PostMapping("/recipe-add")
    public  String doAddRecipe(
            @Valid AddRecipeDto data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("recipeData", data);
            redirectAttributes.addFlashAttribute(
                    "org.sprigframework.validation.BindingResult.recipeData", bindingResult);


            return "redirect:/recipe-add";
        }
        boolean success = recipeService.create(data);

        if(!success) {
            //duplicate name
            redirectAttributes.addFlashAttribute("recipeData", data);
            return "redirect:/recipe-add";

        }
        return "redirect:/recipe-add";
    }

}
