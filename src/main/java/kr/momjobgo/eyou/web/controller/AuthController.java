package kr.momjobgo.eyou.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.momjobgo.eyou.web.dto.Token;
import kr.momjobgo.eyou.web.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(AuthController.PREFIX)
public class AuthController {

    public static final String PREFIX = "/user";

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid Token.TokenRequest request) throws JsonProcessingException {
        return ResponseEntity.ok().body(userService.login(request));
    }
}
