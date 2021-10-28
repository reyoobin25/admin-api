package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 한건에 대해 가장 최근의 1건이 리턴된다.
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

}
