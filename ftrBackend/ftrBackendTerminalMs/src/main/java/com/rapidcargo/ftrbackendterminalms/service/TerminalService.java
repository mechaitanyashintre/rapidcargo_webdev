package com.rapidcargo.ftrbackendterminalms.service;

import java.util.List;
import com.rapidcargo.ftrbackendterminalms.dto.TerminalDTO;
import com.rapidcargo.ftrbackendterminalms.exception.TerminalException;

public interface TerminalService {

    TerminalDTO insertNewTerminal(TerminalDTO terminalDTO);

    List<TerminalDTO> fetchFTRTerminals() throws TerminalException;

    String updateTerminal(String terminalId, Integer newCapacity) throws TerminalException;

    List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws TerminalException;

    String removeTerminal(String terminalId) throws TerminalException;

    TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws TerminalException;
}
