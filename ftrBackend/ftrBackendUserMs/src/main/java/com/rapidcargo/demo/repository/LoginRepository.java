// FtrBackendUserMs/src/main/java/com/infosys/ftrbackenduserms/repository/LoginRepository.java
package com.infosys.ftrbackenduserms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.ftrbackenduserms.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {}
