package com.htm.backend.dto;

import lombok.Getter;

@Getter
public class PostListResponse {
    private Long id;
    private String title;
    private String content;

    public PostListResponse(Long id, String title, String content) {    // service에서 직접 new로 생성하기 때문에 불완전한 객체 생성 방지를 위해 커스텀 생성자
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
