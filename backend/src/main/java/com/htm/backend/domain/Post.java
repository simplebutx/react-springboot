package com.htm.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)   // 기본 생성자는 JPA만 쓰게하고, 외부에서는 마음대로 new 하지 못하게 막겠다
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    public Post(String title, String content) {    // 생성자가 있으면 title, content가 둘다 있어야만 생성 가능 (데이터의 구조를 강제, 데이터의 일관성)
        this.title = title;
        this.content = content;
    }
}
