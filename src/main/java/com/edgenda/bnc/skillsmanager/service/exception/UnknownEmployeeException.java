package com.edgenda.bnc.skillsmanager.service.exception;

public class UnknownEmployeeException extends RuntimeException {

    public UnknownEmployeeException(Long id) {
        super("Unknown Employee with ID=" + id);
    }

}
