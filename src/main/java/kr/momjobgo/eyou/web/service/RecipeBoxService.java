package kr.momjobgo.eyou.web.service;

import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.TestJoinEntity;

import java.util.List;

public interface RecipeBoxService {

    List<RecipeBoxEntity> testJoin();

    List<TestJoinEntity> testJoin2();

    List<RecipeBoxEntity> getAll();

    RecipeBoxEntity getTest(Long id);

    RecipeBoxEntity insertTest(String name);

    RecipeBoxEntity insertTest2(RecipeBoxEntity entity);

    RecipeBoxEntity updateTest(RecipeBoxEntity entity);
    String deleteTest(Long id);

    List<RecipeBoxEntity> findByName(String name);

    List<RecipeBoxEntity> findByName2(String name);
}
