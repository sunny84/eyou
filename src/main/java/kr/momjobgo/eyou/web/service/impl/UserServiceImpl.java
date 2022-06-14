package kr.momjobgo.eyou.web.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.momjobgo.eyou.config.security.JwtTokenProvider;
import kr.momjobgo.eyou.web.dto.Token;
import kr.momjobgo.eyou.web.jpa.entity.TestEntity;
import kr.momjobgo.eyou.web.jpa.entity.TestJoinEntity;
import kr.momjobgo.eyou.web.jpa.entity.UserEntity;
import kr.momjobgo.eyou.web.jpa.repository.TestJoinRepository;
import kr.momjobgo.eyou.web.jpa.repository.UserRepository;
import kr.momjobgo.eyou.web.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TestJoinRepository testJoinRepository;

    public UserServiceImpl(UserRepository userRepository, TestJoinRepository testJoinRepository){
        this.userRepository = userRepository;
        this.testJoinRepository = testJoinRepository;
    }

    @Override
    public List<UserEntity> testJoin() {
        return userRepository.findAll();
    }

    @Override
    public List<TestJoinEntity> testJoin2() {
        return testJoinRepository.findAll();
    }
    @Override
    public List<UserEntity> getAllUser(){
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public Token.TokenResponse login(Token.TokenRequest request) throws JsonProcessingException {

        Optional<UserEntity> entity = userRepository.findBySnsId(request.getSnsId());

        System.out.println("entity : " + entity);

        String token = null;

        if(entity.isPresent()){
            token = JwtTokenProvider.generateToken(entity.get());
        } else {
            UserEntity newUser = new UserEntity();
            newUser.setSnsId(request.getSnsId());
            token = JwtTokenProvider.generateToken(userRepository.save(newUser));
        }

        return Token.TokenResponse.builder().token(token).build();
    }

}
