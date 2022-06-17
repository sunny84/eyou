package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.UserEntity;
import kr.momjobgo.eyou.web.jpa.repository.RecipeBoxRepository;
import kr.momjobgo.eyou.web.jpa.repository.RecipeRecipeBoxRepository;
import kr.momjobgo.eyou.web.jpa.repository.RecipeRepository;
import kr.momjobgo.eyou.web.jpa.repository.UserRepository;
import kr.momjobgo.eyou.web.service.RecipeBoxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeBoxServiceImpl implements RecipeBoxService {
    private final RecipeBoxRepository recipeBoxRepository;
    private final RecipeRecipeBoxRepository recipeRecipeBoxRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public RecipeBoxServiceImpl(RecipeBoxRepository recipeBoxRepository, RecipeRecipeBoxRepository recipeRecipeBoxRepository, UserRepository userRepository, RecipeRepository recipeRepository) {
        this.recipeBoxRepository = recipeBoxRepository;
        this.recipeRecipeBoxRepository = recipeRecipeBoxRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeRecipeBoxEntity> getRecipeRecipeBox() {
        return recipeRecipeBoxRepository.findAll();
    }
    @Override
    public List<RecipeEntity> getRecipe() { return recipeRepository.findAll(); }

    @Override
    public List<UserEntity> getUser() { return userRepository.findAll(); }

    // 모두 가져오기.
    @Override
    public List<RecipeBoxEntity> getAll() {
        return recipeBoxRepository.findAll();
    }

    @Override
    public RecipeBoxEntity getRecipeBoxId(Long id) {

        Optional<RecipeBoxEntity> recipeBoxEntity = recipeBoxRepository.findById(id);

        if(recipeBoxEntity.isPresent()){
            return recipeBoxEntity.get();
        } else {
            return null;
        }

    }

    @Override
    public RecipeBoxEntity insertRecipeBoxName(String name) {

        RecipeBoxEntity recipeBoxEntity = new RecipeBoxEntity();
        recipeBoxEntity.setName(name);

        return recipeBoxRepository.save(recipeBoxEntity);
    }

    @Override
    public RecipeBoxEntity insertRecipeBox(RecipeBoxEntity entity) {
        return recipeBoxRepository.save(entity);
    }

    @Override
    public RecipeBoxEntity updateRecipeBox(RecipeBoxEntity entity) {

        RecipeBoxEntity result = null;

        Optional<RecipeBoxEntity> recipeBoxEntity = recipeBoxRepository.findById(entity.getId());

        if(recipeBoxEntity.isPresent()){
//            if(recipeBoxEntity.get().getId().equals('UserId'){
//                result = recipeBoxRepository.save(entity);
//            }
            result = recipeBoxRepository.save(entity);
        }
        return result;
    }

    @Override
    public String deleteRecipeBox(Long id) {
        recipeBoxRepository.deleteById(id);
        return "삭제성공";
    }

    @Override
    public List<RecipeBoxEntity> findByName(String name) {
        return recipeBoxRepository.findByName(name);
    }

    @Override
    public List<RecipeBoxEntity> findByNameContains(String name) {
        return recipeBoxRepository.findByNameContains(name);
    }
}
