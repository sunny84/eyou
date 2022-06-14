package kr.momjobgo.eyou.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.momjobgo.eyou.web.dto.Token;
import kr.momjobgo.eyou.web.jpa.entity.TestEntity;
import kr.momjobgo.eyou.web.jpa.entity.TestJoinEntity;
import kr.momjobgo.eyou.web.jpa.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> testJoin();

    List<TestJoinEntity> testJoin2();
    List<UserEntity> getAllUser();

    Token.TokenResponse login(Token.TokenRequest request) throws JsonProcessingException;
}
