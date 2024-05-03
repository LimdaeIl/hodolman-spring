package com.hodolog.hodolog.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostCreate {

    @NotBlank(message = "타이틀을 입력해주세요.")
    private final String title;

    @NotBlank(message = "콘텐츠를 입력해주세요.")
    private final String content;

    @Builder // 개인적으로 생성자에 붙이기: 클래스에 붙이게되면 필드가 final 인지 아닌지에 따라 빌더 클래스 모순이 발생할 가능성이 존재한다.
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * 빌더의 장점: 객체의 불변성, 가독성, 객체 생성 유연함, 필요한 값만 할당이 가능
     * 생성자 방식 -> 코드 늘어나고, 오버로딩이 수행되어야 한다.
     * 오버로딩이 가능한 조건과 관련이 있다.
     */
    // private final 까지 선호하는 편. final 적용된 필드는 새로 객체를 복사해서 새로 생성해야 한다.
//    public PostCreate changeTitle(String title) {
//        return PostCreate.builder()
//                .content(content)
//                .title(title)
//                .build();
//    }
}
