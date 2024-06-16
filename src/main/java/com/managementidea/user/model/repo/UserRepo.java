package com.managementidea.user.model.repo;

import com.managementidea.user.model.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, String> {

    @Query("{ $or: [ {'userInfo.mobileNo': ?0}, {'userInfo.email': ?1} ] }")
    Optional<UserEntity> findByMobileNoOrEmail(String mobileNo, String email);
 }