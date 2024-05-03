package com.hodolog.hodolog.controller;

import com.hodolog.hodolog.request.PostCreate;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Log4j2
public class PostController {

    // HTTP Method: GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT
    // 글 등록: POST Method

    @PostMapping("/posts")
    public String post(@RequestBody PostCreate postCreate) {
        log.info("postCreate.toString(): {}", postCreate.toString());
        return "Hello World!";
    }
}
