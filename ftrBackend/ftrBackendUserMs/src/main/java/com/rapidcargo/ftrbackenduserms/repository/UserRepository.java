// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/repository/UserRepository.java
package com.rapidcargo.ftrbackenduserms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rapidcargo.ftrbackenduserms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {}
