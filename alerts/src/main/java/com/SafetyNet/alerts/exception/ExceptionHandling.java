package com.SafetyNet.alerts.exception;

import com.SafetyNet.alerts.controller.UrlEndpointsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandling {
    Logger logger = LoggerFactory.getLogger(UrlEndpointsController.class);

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseBody
    public ExceptionResponse handleConstraintViolationException(HttpClientErrorException.BadRequest constraintViolationException, HttpServletRequest request, HttpServletResponse responseCode) {
        responseCode.setStatus(400);
        ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.BAD_REQUEST.value(), constraintViolationException.getLocalizedMessage(), request.getRequestURI());
        logger.error("Exception 400", constraintViolationException);
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ExceptionResponse handleNoFoundException(NotFoundException constraintViolationException, HttpServletRequest request, HttpServletResponse responseCode) {
        responseCode.setStatus(404);
        ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), constraintViolationException.getLocalizedMessage(), request.getRequestURI());
        logger.error("Parameter Not Found Exception 404", constraintViolationException);
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionResponse handleNoFoundException(Exception constraintViolationException, HttpServletRequest request, HttpServletResponse responseCode) {
        responseCode.setStatus(500);
        ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), constraintViolationException.getLocalizedMessage(), request.getRequestURI());
        logger.error("Exception 500", constraintViolationException);
        return response;
    }
}
