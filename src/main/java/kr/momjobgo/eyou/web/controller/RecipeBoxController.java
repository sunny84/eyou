package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.common.FileService;
import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.repository.FileRepository;
import kr.momjobgo.eyou.web.jpa.repository.RecipeBoxRepository;
import kr.momjobgo.eyou.web.service.RecipeBoxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Integer 숫자 8byte
     * String 글자
     * Double
     * @return
     */

    @GetMapping("/recipebox")
    public ResponseEntity<?> getRecipeRecipeBox() {
        return ResponseEntity.ok(recipeBoxService.getRecipeRecipeBox());
    }
    @GetMapping("/recipe")
    public ResponseEntity<?> getRecipe() { return ResponseEntity.ok(recipeBoxService.getRecipe()); }
    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(recipeBoxService.getUser());
    }

    @GetMapping("/recipebox/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body( recipeBoxService.getAll() );
    }

    @GetMapping("/recipebox/{id}")
    public ResponseEntity<?> getRecipeBoxId(@PathVariable Long id) {
        return ResponseEntity.ok().body( recipeBoxService.getRecipeBoxId(id) );
    }

    @PostMapping("/recipebox/name")
    public ResponseEntity<?> postRecipeBoxName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeBoxService.insertRecipeBoxName(name));
    }

    @PostMapping("/recipebox/entity")
    public ResponseEntity<?> postRecipeBox(@RequestBody RecipeBoxEntity recipeBoxEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeBoxService.insertRecipeBox(recipeBoxEntity));
    }

    @PatchMapping("/recipebox/{id}")
    public ResponseEntity<?> updateRecipeBox(@RequestBody RecipeBoxEntity recipeBoxEntity){
        return ResponseEntity.ok().body(recipeBoxService.updateRecipeBox(recipeBoxEntity));
    }

    @DeleteMapping("/recipebox/{id}")
    public ResponseEntity<?> deleteRecipeBox(@PathVariable Long id) {
        return ResponseEntity.ok().body(recipeBoxService.deleteRecipeBox(id));
    }

    @GetMapping("/recipebox/name")
    public ResponseEntity<?> getRecipeBoxByName(@RequestParam String name){
        return ResponseEntity.ok().body(recipeBoxService.findByName(name));
    }

    @GetMapping("/recipebox/names")
    public ResponseEntity<?> getRecipeBoxByNameContains(@RequestParam String name){
        return ResponseEntity.ok().body(recipeBoxService.findByNameContains(name));
    }

}
