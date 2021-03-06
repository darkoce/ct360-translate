package com.zepp.translate.controllers.advice;

import com.zepp.translate.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception exception){

        log.error("Handling Number Format Exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("error/400error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("error/404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleDefaultError(HttpServletRequest req, Exception exception){

        log.error("Handling Number Format Exception");
        log.error(exception.getMessage());
        log.error("url je " + req.getRequestURL());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("error/400error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }*/

}
