package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.entity.CategoryName;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final UserSession userSession;
    private RecipeService recipeService;

    public HomeController(UserSession userSession, RecipeService recipeService) {
        this.userSession = userSession;
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public  String  nonLoggedIndex() {
        if(userSession.isLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public  String loggedInIndex(Model model) {
        if(userSession.isLoggedIn()) {
            return "redirect:/";
        }
        Map<CategoryName, List<Recipe>> allRecipes = recipeService.findAllByCategory();
        model.addAttribute("cocktailsData",allRecipes.get(CategoryName.COCKTAIL));

//        recipeService.findFavourites(userSession.id());
        return "home";
    }

}
