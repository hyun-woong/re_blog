package com.sparta.re_blog.controller;


import com.sparta.re_blog.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/mainPost/{id}")
    public Blog getMainPost(@PathVariable Long id) {return blogRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
    );
    }

    @DeleteMapping("/api/mainPost/{id}")
    public Long deletePost(@PathVariable Long id){
        blogRepository.deleteById(id);
        return id;
    }

}


