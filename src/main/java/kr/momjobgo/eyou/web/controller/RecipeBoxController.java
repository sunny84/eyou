package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.jpa.entity.RecipeRecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.entity.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/recipe-box")
public class RecipeBoxController {
//    @GetMapping("/all")
//    public List<RecipeRecipeBoxEntity> getAll(@AuthenticationPrincipal UserEntity entity){
//        return null;
//    }
}
