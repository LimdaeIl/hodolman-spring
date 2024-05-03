package com.hodolog.hodolog.controller;

import com.hodolog.hodolog.domain.Post;
import com.hodolog.hodolog.request.PostCreate;
import com.hodolog.hodolog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        postService.write(request);
    }

    /**
     * /posts -> 글 전체 조회(검색 + 페이징)
     * /posts/{postId} -> 글 한 개 조회
     */
    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable(name = "postId") Long postId) {
        Post post = postService.get(postId);
        return postService.get(postId);
    }


}
