package com.linminrui.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class BlogsController {

    @GetMapping("blogs")
    public String blogsUI(){
        return "admin/blogs";
    }

}
