package kr.momjobgo.eyou.web.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "RECIPE_RECIPEBOX_MAP")
public class RecipeRecipeBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "recipe_box_id")
    private Long recipeBoxId;

    @Column(name = "user_id")
    private Long userId;
}
