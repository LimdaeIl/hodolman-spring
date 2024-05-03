package com.hodolog.hodolog.controller;

import com.hodolog.hodolog.request.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
public class PostController {

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstError = fieldErrors.get(0);
            String fieldName = firstError.getField(); // title
            String errorMessage = firstError.getDefaultMessage(); // .. 에러 메세지

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }

        log.info("BindingResult: {}", result.toString());

        /**
         * 데이터를 검증하는 이유
         * 1. Client 개발자가 깜빡할 수 있다. 실수로 값을 안보낼 수 있다.
         * 2. Client Bug 으로 값이 누락될 수 있다.
         * 3. 외부에 나쁜 사람이 값을 임의로 조작해서 보낼 수 있다.
         * 4. DB에 값을 저장할 때 의도치 않은 오류가 발생할 수 있다.
         * 5. 서버 개발자의 편안함을 위해서
         */

        // @NotBlank 으로 대체 가능
//        String title = params.getTitle();
//        if (title == null || title.equals("")) {
//            throw new Exception("타이틀 값이 없어요!");
//            // 1. 이 방식 예외 처리는 빡세다. (노가다)
//            // 2. 개발팁 -> 무언가 3번 이상 반복 작업을 할 때 내가 뭔가 잘못하고 있는건 아닌지 의심한다.
//            // 3. 누락가능성
//            // 4. 생각보다 검증해야할 게 많다. (꼼꼼하지 않을 수 있다.)
//            // 5. 뭔가 개발자 스럽지 않다. -> 간지 X
//            //  title 예외 상황
//            // {"title": ""}
//            // {"title": "                   "}
//            // {"title": "...........수십억글자"}
//        }
//
//        String content = params.getContent();
//        if (content == null || content.equals("")) {
//            // error
//        }

        log.info("params.toString(): {}", params.toString());
        return Map.of();
    }
}
