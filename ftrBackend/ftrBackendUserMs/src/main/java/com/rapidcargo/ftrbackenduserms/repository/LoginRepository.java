// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/repository/LoginRepository.java
package com.rapidcargo.ftrbackenduserms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rapidcargo.ftrbackenduserms.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {}
