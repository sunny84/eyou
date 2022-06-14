package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "RECIPE")
@Data
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
//
//    @OneToMany(mappedBy = "recipe_id")
//    private List<RecipeRecipeBoxEntity> recipeBoxs = new ArrayList<>();
}
