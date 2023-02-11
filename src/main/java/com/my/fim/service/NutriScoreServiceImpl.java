package com.my.fim.service;

import com.my.fim.model.NutriScore;
import com.my.fim.repository.NutriScoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NutriScoreServiceImpl implements NutriScoreService{

    private final NutriScoreRepository nutriScoreRepository;
    @Override
    public NutriScore createNutriScore(NutriScore nutriScore) {
        return nutriScoreRepository.save(nutriScore);
    }

    @Override
    public List<NutriScore> findAllNutriScore() {
        return nutriScoreRepository.findAll();
    }

    @Override
    public NutriScore updateNutriScore(Long id, NutriScore nutriScore) {
        return nutriScoreRepository.findById(id)
                .map(element->{
                    element.setCode(nutriScore.getCode());
                    return nutriScoreRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Nutriscore non trouvé."));
    }

    @Override
    public String deleteNutriScore(Long id) {
        nutriScoreRepository.deleteById(id);
        return "Nutriscore supprimé !";
    }
}
