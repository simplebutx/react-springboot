package com.htm.backend.dto;

import lombok.Getter;

@Getter
public class PostDetailResponse {
    private Long id;
    private String title;
    private String content;

    public PostDetailResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
