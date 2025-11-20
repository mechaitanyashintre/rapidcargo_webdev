package com.infosys.ftrbackendworkitemms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.infosys.ftrbackendworkitemms.entity.Workitem;

@Repository
public interface WorkitemRepository extends JpaRepository<Workitem, String> {
    @Query("select workitemId from Workitem")
    List<String> getAllWorkitemId();

    List<Workitem> findByUserId(Long userId);
}
