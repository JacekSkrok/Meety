package com.jacek.meety.exception;

import com.jacek.meety.controllers.AppointmentsController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    Logger logger = Logger.getLogger(AppointmentsController.class.getName());
    public ResourceNotFoundException(String message) {
        logger.log(Level.WARNING, message);
    }
}
