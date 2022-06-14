package kr.momjobgo.eyou;

import kr.momjobgo.eyou.web.jpa.entity.RecipeBoxEntity;
import kr.momjobgo.eyou.web.jpa.repository.RecipeBoxRepository;
import kr.momjobgo.eyou.web.jpa.repository.TestJoinRepository;
import kr.momjobgo.eyou.web.service.RecipeBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(EyouApplication.class, args);
    }

}

// https://jdm.kr/blog/141 커멘드라인 실행방법?
//class Jpa3Application implements CommandLineRunner {
//    @Autowired
//    private RecipeBoxRepository rbr;
//    @Autowired
//    private TestJoinRepository tjr;
//
//    public static void main(String[] args) {
//        SpringApplication.run(Jpa3Application.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        RecipeBoxEntity first = new RecipeBoxEntity("first");
//
//    }
//}
