package com.rapidcargo.ftrbackendterminalms.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rapidcargo.ftrbackendterminalms.dto.TerminalDTO;
import com.rapidcargo.ftrbackendterminalms.entity.Terminal;
import com.rapidcargo.ftrbackendterminalms.exception.TerminalException;
import com.rapidcargo.ftrbackendterminalms.repository.TerminalRepository;
import com.rapidcargo.ftrbackendterminalms.service.TerminalService;

@RestController
@RequestMapping("terminals")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @Autowired
    private TerminalRepository terminalRepository;

    @PostMapping
    public ResponseEntity<TerminalDTO> insertNewTerminal(@RequestBody @Valid TerminalDTO tDTO) {
        return new ResponseEntity<>(terminalService.insertNewTerminal(tDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TerminalDTO>> fetchFTRTerminals() throws TerminalException {
        return new ResponseEntity<>(terminalService.fetchFTRTerminals(), HttpStatus.OK);
    }

    @PutMapping("/{terminalId}/{newCapacity}")
    public ResponseEntity<String> updateTerminal(@PathVariable String terminalId, @PathVariable Integer newCapacity) throws TerminalException {
        return new ResponseEntity<>(terminalService.updateTerminal(terminalId, newCapacity), HttpStatus.OK);
    }

    @GetMapping("/fetchTerminalsByItemType/{itemType}")
    public ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(@PathVariable String itemType) throws TerminalException {
        return new ResponseEntity<>(terminalService.fetchTerminalsByItemType(itemType), HttpStatus.OK);
    }

    @DeleteMapping("/{terminalId}")
    public ResponseEntity<String> removeTerminal(@PathVariable String terminalId) throws TerminalException {
        return new ResponseEntity<>(terminalService.removeTerminal(terminalId), HttpStatus.OK);
    }

    @GetMapping("/{terminalId}")
    public ResponseEntity<TerminalDTO> fetchTerminalByTerminalId(@PathVariable String terminalId) throws TerminalException {
        return new ResponseEntity<>(terminalService.fetchFTRTerminalByTerminalId(terminalId), HttpStatus.OK);
    }

    @GetMapping("/checkItemType/{terminalId}/{workItemType}")
    public boolean checkItemType(@PathVariable String terminalId, @PathVariable String workItemType) {
        Optional<Terminal> result = terminalRepository.findById(terminalId);
        Terminal terminal = result.get();
        return terminal.getItemType().equals(workItemType);
    }

    @PutMapping("/updateTerminalCapacity/{terminalId}/{quantity}")
    public void updateTerminalCapacity(@PathVariable String terminalId, @PathVariable String quantity) {
        Optional<Terminal> result = terminalRepository.findById(terminalId);
        Terminal terminal = result.get();
        int temp2 = terminal.getAvailableCapacity() + Integer.parseInt(quantity);
        if (temp2 < terminal.getCapacity()) {
            terminal.setAvailableCapacity(temp2);
            terminalRepository.save(terminal);
        }
    }

    @PostMapping("/assignTerminal/{workItemType}/{quantity}")
    public String assignTerminal(@PathVariable String workItemType, @PathVariable String quantity) {
        if (workItemType.contains("-")) {
            workItemType = workItemType.replaceAll("_", " ");
        }

        List<Terminal> result = terminalRepository.findByItemType(workItemType);
        Terminal terminalOp = new Terminal();

        for (Terminal terminal : result) {
            if (terminal.getStatus().equals("Available")) {
                terminal.setAvailableCapacity(terminal.getAvailableCapacity() - Integer.parseInt(quantity));
                terminalOp = terminal;
                break;
            }
        }

        terminalRepository.save(terminalOp);
        return terminalOp.getTerminalId();
    }
}
