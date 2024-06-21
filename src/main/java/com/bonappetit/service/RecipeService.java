package com.bonappetit.service;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.AddRecipeDto;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.repo.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserSession userSession;

    public RecipeService(RecipeRepository recipeRepository, UserSession userSession) {
        this.recipeRepository = recipeRepository;
        this.userSession = userSession;
    }

    public boolean create(AddRecipeDto data) {
        Optional<Recipe> byName = recipeRepository.findByName(data.getName());

        return false;

    }
}
