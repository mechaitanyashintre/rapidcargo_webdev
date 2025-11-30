package com.rapidcargo.ftrbackendterminalms.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.rapidcargo.ftrbackendterminalms.dto.TerminalDTO;
import com.rapidcargo.ftrbackendterminalms.exception.TerminalException;
import com.rapidcargo.ftrbackendterminalms.exception.TerminalException;

@Component
public class TerminalValidator {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z ]{3,20}$");
    private static final Pattern ITEM_PATTERN = Pattern.compile("^[A-Za-z ]{4,30}$");
    private static final Pattern DESC_PATTERN = Pattern.compile("^.{1,25}$");

    public void validate(TerminalDTO terminalDTO) throws TerminalException {

        if (terminalDTO.getTerminalName() == null || terminalDTO.getTerminalName().trim().isEmpty()) {
            throw new TerminalException("terminal.terminalName.must");
        }
        if (!NAME_PATTERN.matcher(terminalDTO.getTerminalName()).matches()) {
            throw new TerminalException("terminal.terminalName.invalid");
        }

        if (terminalDTO.getCountry() == null || terminalDTO.getCountry().trim().isEmpty()) {
            throw new TerminalException("terminal.country.must");
        }
        if (!NAME_PATTERN.matcher(terminalDTO.getCountry()).matches()) {
            throw new TerminalException("terminal.country.invalid");
        }

        if (terminalDTO.getItemType() == null || terminalDTO.getItemType().trim().isEmpty()) {
            throw new TerminalException("terminal.itemType.must");
        }
        if (!ITEM_PATTERN.matcher(terminalDTO.getItemType()).matches()) {
            throw new TerminalException("terminal.itemType.invalid");
        }

        if (terminalDTO.getTerminalDescription() == null || terminalDTO.getTerminalDescription().trim().isEmpty()) {
            throw new TerminalException("terminal.terminalDescription.must");
        }
        if (!DESC_PATTERN.matcher(terminalDTO.getTerminalDescription()).matches()) {
            throw new TerminalException("terminal.terminalDescriptionLength.invalid");
        }

        if (terminalDTO.getCapacity() == null) {
            throw new TerminalException("terminal.capacity.must");
        }
        if (terminalDTO.getCapacity() > 99999) {
            throw new TerminalException("terminal.capacity.invalid");
        }

        if (terminalDTO.getAvailableCapacity() == null) {
            throw new TerminalException("terminal.capacity-must");
        }
        if (terminalDTO.getAvailableCapacity() > 99999) {
            throw new TerminalException("terminal.capacity.invalid");
        }

        if (terminalDTO.getStatus() == null || terminalDTO.getStatus().trim().isEmpty()) {
            throw new TerminalException("terminal.status.must");
        }
        if (!terminalDTO.getStatus().equalsIgnoreCase("Available") &&
            !terminalDTO.getStatus().equalsIgnoreCase("Not Available")) {
            throw new TerminalException("terminal.status.invalid");
        }
    }
}
