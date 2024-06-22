package com.bonappetit.service;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.AddRecipeDto;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.CategoryName;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.CategoryRepository;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserSession userSession;
    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    public RecipeService(RecipeRepository recipeRepository, UserSession userSession, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.userSession = userSession;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public boolean create(AddRecipeDto data) {
        if(!userSession.isLoggedIn()) {
            return false;
        }

        Optional<User> byId = userRepository.findById(userSession.id());

        if (byId.isEmpty()){
            return false;
        }

        Optional<Category> byName = categoryRepository.findByName(data.getCategory());

        if(byName.isEmpty()){
            return false;
        }

        Recipe recipe = new Recipe();
        recipe.setName(data.getName());
        recipe.setIngredients(data.getIngredients());
        recipe.setCategory(byName.get());
        recipe.setAddedBy(byId.get());
        recipeRepository.save(recipe);

        return true;

    }

    public Map<CategoryName, List<Recipe>> findAllByCategory() {
       Map<CategoryName, List<Recipe>> result = new HashMap<>();

        List<Category> allCategories = categoryRepository.findAll();

        for (Category cat : allCategories) {
            List<Recipe> recipes = recipeRepository.findAllByCategory(cat);

            result.put(cat.getName(),recipes);
        }
        return result;
    }
@Transactional
    public void addToFavourites(Long id, long recipeId) {
        Optional<User> userOpt = userRepository.findById(id);

        if(userOpt.isEmpty()) {
            return;
        }
        Optional<Recipe> recipeOpt = recipeRepository.findById(recipeId);

        if(recipeOpt.isEmpty()) {
            return;
        }
        userOpt.get().addFavourite(recipeOpt.get());

        userRepository.save(userOpt.get());

    }

}
