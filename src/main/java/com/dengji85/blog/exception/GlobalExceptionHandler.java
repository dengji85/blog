package com.dengji85.blog.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.getMessage());
		mav.addObject("url", req.getRequestURL());
		
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;

	}

}
