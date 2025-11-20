package com.rapidcargo.ftrbackendterminalms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rapidcargo.ftrbackendterminalms.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, String> {

    @Query("select terminalId from Terminal")
    List<String> getAllTerminalId();

    List<Terminal> findByItemType(String workItemType);
}
