package com.rapidcargo.ftrbackendworkitemms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("FTRBACKENDTERMINALMS")
public interface TerminalMsFeign {
    @PutMapping("/terminals/updateTerminalCapacity/{terminalId}/{quantity}")
    void updateTerminalCapacity(@PathVariable String terminalId, @PathVariable String quantity);

    @PostMapping("/terminals/assignTerminal/{workItemType}/{quantity}")
    String assignTerminal(@PathVariable String workItemType, @PathVariable String quantity);

    @GetMapping("/terminals/checkItemType/{terminalId}/{workItemType}")
    boolean checkItemType(@PathVariable String terminalId, @PathVariable String workItemType);
}
