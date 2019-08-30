package com.linminrui.blog.handle;

import com.linminrui.blog.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//自定义一个ControllerAdvice ，来处理除了我们自定义的异常后要怎么处理
@ControllerAdvice
public class HandleException {

    private final Logger logger  = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView exceptionHandle(HttpServletRequest request, Exception e) throws Exception{

        if(logger.isDebugEnabled()){
            logger.error("Requrst URL : {}, Exception : {}", request.getRequestURL(), e);
        }

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURI());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
