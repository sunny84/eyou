package kr.momjobgo.eyou.web.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "TEST")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    // 양방향 조회시 시작
    /*
        양방향 조회 시 @JsonBackReference 을 가지고 있는 객체는 response에 표시되지 않음 (순환참조되기 때문)
        java내에서는 사용가능 하지만 애초에 양방향은 사용하지 않는것이 좋음.
        단방향으로 조회하는것이 이상적.
     */
//    @JsonManagedReference
//    @OneToMany(mappedBy = "testEntity", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private List<TestJoinEntity> testJoinEntities = new ArrayList<>();
    // 양방향 조회시 끝

    // 단방향 조회1 시작
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private List<TestJoinEntity> testJoinEntities = new ArrayList<>();
    // 단방향 조회1 끝

    // 단방향 조회2 시작

    // 단방향 조회2 끝
}
