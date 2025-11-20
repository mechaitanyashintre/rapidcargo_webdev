package com.rapidcargo.ftrbackendterminalms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.rapidcargo.ftrbackendterminalms.dto.TerminalDTO;
import com.rapidcargo.ftrbackendterminalms.entity.Terminal;
import com.rapidcargo.ftrbackendterminalms.exception.TerminalException;
import com.rapidcargo.ftrbackendterminalms.repository.TerminalRepository;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class TerminalServiceImp implements TerminalService {

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private Environment env;

    @Override
    public TerminalDTO insertNewTerminal(TerminalDTO terminalDTO) {
        List<String> allTerminalId = terminalRepository.getAllTerminalId();
        String temp1 = allTerminalId.get(allTerminalId.size() - 1);
        int temp2 = Integer.parseInt(temp1.substring(1)) + 1;
        terminalDTO.setTerminalId("T" + temp2);
        Terminal terminal = Terminal.toEntity(terminalDTO);
        terminalRepository.save(terminal);
        return TerminalDTO.toDto(terminal);
    }

    @Override
    public List<TerminalDTO> fetchFTRTerminals() throws TerminalException {
        Iterable<Terminal> result = terminalRepository.findAll();
        List<TerminalDTO> terminalList = new ArrayList<>();
        if (!result.iterator().hasNext()) {
            throw new TerminalException("terminal.empty");
        }
        for (Terminal terminal : result) {
            terminalList.add(TerminalDTO.toDto(terminal));
        }
        return terminalList;
    }

    @Override
    public String updateTerminal(String terminalId, Integer newCapacity) throws TerminalException {
        try {
            Optional<Terminal> result = terminalRepository.findById(terminalId);
            Terminal terminal = result.orElseThrow(() -> new TerminalException("terminal.notFound"));
            if (terminal.getAvailableCapacity() < newCapacity) {
                throw new TerminalException("terminal.capacity.failed");
            }
            if (terminal.getAvailableCapacity().equals(newCapacity)) {
                terminal.setStatus("Unavailable");
            }
            terminal.setCapacity(newCapacity);
            terminalRepository.save(terminal);
            return "Terminal capacity is successfully reduced for ID: " + terminalId;
        } catch (Exception e) {
            return new TerminalException(env.getProperty("terminal.capacity.failed")).getMessage();
        }
    }

    @Override
    public List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws TerminalException {
        List<Terminal> result = terminalRepository.findByItemType(itemType);
        if (result.isEmpty()) {
            throw new TerminalException("terminal.itemtype.notFound");
        }
        List<TerminalDTO> dtoList = new ArrayList<>();
        for (Terminal terminal : result) {
            dtoList.add(TerminalDTO.toDto(terminal));
        }
        return dtoList;
    }

    @Override
    public String removeTerminal(String terminalId) throws TerminalException {
        try {
            Optional<Terminal> result = terminalRepository.findById(terminalId);
            Terminal terminal = result.orElseThrow(() -> new TerminalException("terminal.notFound"));
            terminalRepository.delete(terminal);
            return "Terminal details are deleted successfully.";
        } catch (Exception e) {
            return new TerminalException(env.getProperty("terminal.notFound")).getMessage() + terminalId;
        }
    }

    @Override
    public TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws TerminalException {
        Optional<Terminal> result = terminalRepository.findById(terminalId);
        Terminal terminal = result.orElseThrow(() -> new TerminalException("terminal.notFound"));
        return TerminalDTO.toDto(terminal);
    }
}
