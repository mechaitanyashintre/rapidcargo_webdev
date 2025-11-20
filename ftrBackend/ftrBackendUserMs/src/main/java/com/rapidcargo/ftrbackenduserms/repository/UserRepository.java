// FtrBackendUserMs/src/main/java/com/infosys/ftrbackenduserms/repository/UserRepository.java
package com.infosys.ftrbackenduserms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.ftrbackenduserms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {}
