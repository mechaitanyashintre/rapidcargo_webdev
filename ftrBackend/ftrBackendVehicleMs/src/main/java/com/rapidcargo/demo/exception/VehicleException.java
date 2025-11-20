package com.infosys.ftrbackendvehiclems.exception;

public class VehicleException extends Exception {
    private static final long serialVersionUID = 1L;

    public VehicleException(String message) {
        super(message);
    }

    public VehicleException(String message, Throwable cause) {
        super(message, cause);
    }
}
