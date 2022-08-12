package com.SafetyNet.alerts.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ExceptionResponse handleConstraintViolationException(ConstraintViolationException constraintViolationException, HttpServletRequest request, HttpServletResponse responseCode) {
        responseCode.setStatus(400);
        ExceptionResponse response = new ExceptionResponse(new Date(), 400, constraintViolationException.getLocalizedMessage(), request.getRequestURI());
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ExceptionResponse handleNoFoundException(NotFoundException constraintViolationException, HttpServletRequest request, HttpServletResponse responseCode) {
        responseCode.setStatus(404);
        ExceptionResponse response = new ExceptionResponse(new Date(), 404, constraintViolationException.getLocalizedMessage(), request.getRequestURI());
        return response;
    }
}
