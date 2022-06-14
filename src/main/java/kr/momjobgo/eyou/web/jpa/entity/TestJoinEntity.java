package kr.momjobgo.eyou.web.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity(name = "TEST_JOIN")
public class TestJoinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "text")
    private String text;

    // 양방향 조회시 시작
    /*
        양방향 조회 시 @JsonBackReference 을 가지고 있는 객체는 response에 표시되지 않음 (순환참조되기 때문)
        java내에서는 사용가능 하지만 애초에 양방향은 사용하지 않는것이 좋음.
        단방향으로 조회하는것이 이상적.
     */
//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name ="test_id")
//    @ToString.Exclude
//    private TestEntity testEntity;
    // 양방향 조회시 끝

    // 단방향 조회1 시작
    @Column(name = "test_id")
    private Long testId;
    // 단방향 조회1 끝

    // 단방향 조회2 시작
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name ="test_id")
//    private TestEntity testEntity;
    // 단방향 조회2 끝

//    @Column(name = "user_id")
//    private Long userId;
}
