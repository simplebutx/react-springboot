package com.htm.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
// DTO는 외부(HTTP/JSON)와 내부(Entity)를 분리하기 위한 경계 모델이다

@Getter
public class PostCreateRequest {  // 클라이언트가 POST요청으로 보낸 JSON을 자바 객체로 받기 위한 그릇

    @NotBlank    // null / 빈 문자열 / 공백 모두 거부
    private String title;

    @NotBlank
    private String content;

    // JSON → DTO 변환은 Spring(Jackson)이 알아서 맞게 처리하므로 커스텀 생성자가 필요 없음
}
