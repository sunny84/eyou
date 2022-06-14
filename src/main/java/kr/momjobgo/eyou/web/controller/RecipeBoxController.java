package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.common.FileService;
import kr.momjobgo.eyou.web.jpa.repository.FileRepository;
import kr.momjobgo.eyou.web.jpa.repository.RecipeBoxRepository;
import kr.momjobgo.eyou.web.service.RecipeBoxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/recipebox")
public class RecipeBoxController {
    private final RecipeBoxService recipeBoxService;
    private final RecipeBoxRepository recipeBoxRepository;

    public RecipeBoxController(RecipeBoxService recipeBoxService, RecipeBoxRepository recipeBoxRepository) {
        this.recipeBoxService = recipeBoxService;
        this.recipeBoxRepository = recipeBoxRepository;
    }


}
