package kr.momjobgo.eyou.web.service.impl;

import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.TestJoinEntity;
import kr.momjobgo.eyou.web.jpa.repository.RecipeBoxRepository;
import kr.momjobgo.eyou.web.jpa.repository.TestJoinRepository;
import kr.momjobgo.eyou.web.service.RecipeBoxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeBoxServiceImpl implements RecipeBoxService {
    private final RecipeBoxRepository recipeBoxRepository;
    private final TestJoinRepository testJoinRepository;

    public RecipeBoxServiceImpl(RecipeBoxRepository recipeBoxRepository, TestJoinRepository testJoinRepository) {
        this.recipeBoxRepository = recipeBoxRepository;
        this.testJoinRepository = testJoinRepository;
    }

    @Override
    public List<RecipeBoxEntity> testJoin() {
        return recipeBoxRepository.findAll();
    }

    @Override
    public List<TestJoinEntity> testJoin2() {
        return testJoinRepository.findAll();
    }

    // 모두 가져오기.
    @Override
    public List<RecipeBoxEntity> getAll() {
        return recipeBoxRepository.findAll();
    }

    @Override
    public RecipeBoxEntity getTest(Long id) {

        Optional<RecipeBoxEntity> recipeBoxEntity = recipeBoxRepository.findById(id);

        if(recipeBoxEntity.isPresent()){
            return recipeBoxEntity.get();
        } else {
            return null;
        }

    }

    @Override
    public RecipeBoxEntity insertTest(String name) {

        RecipeBoxEntity recipeBoxEntity = new RecipeBoxEntity();
        recipeBoxEntity.setName(name);

        return recipeBoxRepository.save(recipeBoxEntity);
    }

    @Override
    public RecipeBoxEntity insertTest2(RecipeBoxEntity entity) {
        return recipeBoxRepository.save(entity);
    }

    @Override
    public RecipeBoxEntity updateTest(RecipeBoxEntity entity) {

        RecipeBoxEntity result = null;

        Optional<RecipeBoxEntity> recipeBoxEntity = recipeBoxRepository.findById(entity.getId());

        if(recipeBoxEntity.isPresent()){
            if(recipeBoxEntity.get().getName().equals("오준혁")){
                result = recipeBoxRepository.save(entity);
            }
        }
        return result;
    }

    @Override
    public String deleteTest(Long id) {
        recipeBoxRepository.deleteById(id);
        return "삭제성공";
    }

    @Override
    public List<RecipeBoxEntity> findByName(String name) {
        return recipeBoxRepository.findByName(name);
    }

    @Override
    public List<RecipeBoxEntity> findByName2(String name) {
        return recipeBoxRepository.findByNameContains(name);
    }


}
