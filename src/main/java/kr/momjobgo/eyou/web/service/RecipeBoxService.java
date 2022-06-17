package kr.momjobgo.eyou.web.service;

import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.UserEntity;
import kr.momjobgo.eyou.web.jpa.entity.RecipeEntity;

import java.util.List;

public interface RecipeBoxService {

    List<RecipeRecipeBoxEntity> getRecipeRecipeBox();

    List<UserEntity> getUser();
    List<RecipeEntity> getRecipe();

    List<RecipeBoxEntity> getAll();

    RecipeBoxEntity getRecipeBoxId(Long id);

    RecipeBoxEntity insertRecipeBoxName(String name);

    RecipeBoxEntity insertRecipeBox(RecipeBoxEntity entity);

    RecipeBoxEntity updateRecipeBox(RecipeBoxEntity entity);
    String deleteRecipeBox(Long id);

    List<RecipeBoxEntity> findByName(String name);

    List<RecipeBoxEntity> findByNameContains(String name);
}
