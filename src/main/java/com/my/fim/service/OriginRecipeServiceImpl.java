package com.my.fim.service;

import com.my.fim.model.OriginRecipe;
import com.my.fim.repository.OriginRecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OriginRecipeServiceImpl implements OriginRecipeService{

    private final OriginRecipeRepository originRecipeRepository;
    @Override
    public OriginRecipe createOriginRecipe(OriginRecipe originRecipe) {
        return originRecipeRepository.save(originRecipe);
    }

    @Override
    public List<OriginRecipe> findAllOriginRecipe() {
        return originRecipeRepository.findAll();
    }

    @Override
    public OriginRecipe updateOriginRecipe(Long id, OriginRecipe originRecipe) {
        return originRecipeRepository.findById(id)
                .map(element->{
                    element.setType(originRecipe.getType());
                    element.setLocation(originRecipe.getLocation());
                    element.setAuthor(originRecipe.getAuthor());
                    return originRecipeRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Provenance de la recette non trouvé."));
    }

    @Override
    public String deleteOriginRecipe(Long id) {
        originRecipeRepository.deleteById(id);
        return "Provenance de la recette supprimé !";
    }
}
