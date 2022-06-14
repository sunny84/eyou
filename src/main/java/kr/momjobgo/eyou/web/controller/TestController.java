package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.jpa.entity.TestEntity;
import kr.momjobgo.eyou.web.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    /**
     * Integer 숫자 8byte
     * String 글자
     * Double
     * @return
     */

    @GetMapping("/join/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(testService.testJoin());
    }

    @GetMapping("/join/test2")
    public ResponseEntity<?> test2() {
        return ResponseEntity.ok(testService.testJoin2());
    }

    @GetMapping("/test/all")
    public ResponseEntity<?> getAll() {
       return ResponseEntity.ok().body( testService.getAll() );
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<?> getTest(@PathVariable Long id) {
        return ResponseEntity.ok().body( testService.getTest(id) );
    }

    @PostMapping("/test")
    public ResponseEntity<?> postTest(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.CREATED).body(testService.insertTest(name));
    }

    @PostMapping("/test2")
    public ResponseEntity<?> postTest(@RequestBody TestEntity testEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(testService.insertTest2(testEntity));
    }

    @PatchMapping("/test/{id}")
    public ResponseEntity<?> updateTest(@RequestBody TestEntity testEntity){
        return ResponseEntity.ok().body(testService.updateTest(testEntity));
    }

    @DeleteMapping("/test/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable Long id) {
        return ResponseEntity.ok().body(testService.deleteTest(id));
    }

    @GetMapping("/test/name")
    public ResponseEntity<?> getTestByName(@RequestParam String name){
        return ResponseEntity.ok().body(testService.findByName(name));
    }

    @GetMapping("/test/name2")
    public ResponseEntity<?> getTestByName2(@RequestParam String name){
        return ResponseEntity.ok().body(testService.findByName2(name));
    }

}
