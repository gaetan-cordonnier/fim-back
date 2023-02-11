package com.my.fim.service;

import com.my.fim.model.RecipeAuthor;
import com.my.fim.repository.RecipeAuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeAuthorServiceImpl implements RecipeAuthorService{

    private final RecipeAuthorRepository recipeAuthorRepository;

    @Override
    public RecipeAuthor createRecipeAuthor(RecipeAuthor recipeAuthor) {return recipeAuthorRepository.save(recipeAuthor);}

    @Override
    public List<RecipeAuthor> findAllRecipeAuthor() {return recipeAuthorRepository.findAll();}

    @Override
    public RecipeAuthor updateRecipeAuthor(Long id, RecipeAuthor recipeAuthor) {
        return recipeAuthorRepository.findById(id)
            .map(element->{
                element.setFirstname(recipeAuthor.getFirstname());
                element.setLastname(recipeAuthor.getLastname());
                return recipeAuthorRepository.save(element);
            }).orElseThrow(()->new RuntimeException("Auteur non trouvée."));
    }

    @Override
    public String deleteRecipeAuthor(Long id) {
        recipeAuthorRepository.deleteById(id);
        return "Auteur supprimé !";
    }

}
