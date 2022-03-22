package com.sparta.re_blog.controller;


import com.sparta.re_blog.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BlogRestController {

    private final BlogRepository blogRepository;

    @PostMapping("/api/posting")
    public Blog createpost(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blogs")
    public List<Blog> getblog() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/mainPost")
    public List<Blog> getMainPost() {return blogRepository.findAllByOrderByModifiedAtDesc();
    }

}


