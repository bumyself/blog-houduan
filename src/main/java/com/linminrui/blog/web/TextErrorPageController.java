package com.linminrui.blog.web;

import com.linminrui.blog.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextErrorPageController {

    @GetMapping("/")
    public String index( ){
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

}
