package com.hash.exception.impl;

import com.hash.exception.NoResourceFoundException;
import com.hash.exception.model.ErrorInfoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class NoResourceFoundExceptionHandler extends NoResourceFoundException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseBody
    ErrorInfoEntity
    handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ErrorInfoEntity(req.getRequestURL().toString(), ex.getLocalizedMessage());
    }
}
