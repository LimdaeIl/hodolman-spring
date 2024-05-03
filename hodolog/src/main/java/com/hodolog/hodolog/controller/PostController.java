package com.hodolog.hodolog.controller;

import com.hodolog.hodolog.request.PostCreate;
import com.hodolog.hodolog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    // Method POST 수행 이후에 응답을 안하는 경우가 많다. POST: 200, 201 위주
    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        // Case 1. 저장한 데이터 Entity -> response 으로 응답하기
        // Case 2. 저장한 데이터의 primary_id -> response 으로 응답하기:
        //         클라이언트는 수신한 primary_id 를 글 조회 API 를 통해서 데이터를 수신받음
        // Case 3. 저장한 데이터 응답 안하기:
        //         클라이언트에서 모든 POST(글) 데이터 context 를 잘 관리함
        // Bad Case: 서버에서 반드시 이렇게 할껍니다! fix -> X
        //           서버에서 차라리 유연하게 대응하는게 좋습니다. -> 코드를 잘 짜야겠죠?! ㅎ
        //           한 번에 일괄적으로 잘 처리되는 케이스는 없습니다. -> 잘 관리하는 형태가 중요합니다.
        postService.write(request);
    }
}
