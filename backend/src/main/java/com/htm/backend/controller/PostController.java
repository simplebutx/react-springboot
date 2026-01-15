package com.htm.backend.controller;

import com.htm.backend.dto.PostCreateRequest;
import com.htm.backend.dto.PostDetailResponse;
import com.htm.backend.dto.PostListResponse;
import com.htm.backend.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController     // JSON API 컨트롤러임 (메서드 반환 값을 뷰(html)가 아니라 응답바디 (JSON)으로 돌려보냄 (리엑트)
@RequiredArgsConstructor    // final 필드만 대상으로 생성자를 자동 생성해줌 (생성자 주입)
public class PostController {
    private final PostService postService;

    @PostMapping("/api/posts")
    public ResponseEntity<Long> createPost(@Valid @RequestBody PostCreateRequest dto) {    // 클라이언트에서 온 JSON을 PostCreateRequest타입으로 변환해서 이 파라미터(dto)에 넣어라 (결국 저기서 dto는 클라에서온 데이터임)
        Long id = postService.createPost(dto);   // dto 들고 서비스한테 넘김
        return ResponseEntity.status(201).body(id);
    }


// ResponseEntity 클래스 = “HTTP 응답 전체를 담는 그릇” 클래스
// HTTP 응답에는 : 상태코드 (200,401), 헤더, 바디(JSON 데이터)가 있다 -> ResponseEntity는 이걸 전부 담음
// 위 코드에서는 Long타입(id) 응답을 반환할거임

//@Valid는 DTO필드 검증 -> 통과하면 service호출, 실패하면 400
// @RequestBody: HTTP요청의 body(JSON 등)를 자바 객체로 변환해달라는 뜻

// 사용자가 보낸 JSON데이터의 변환 흐름: JSON -> DTO -> ENTITY -> DB에저장 (조회는 역순)
// 데이터의 위치(레이어기준): 클라이언트 -> controller -> service -> repository -> DB

// JSON에서 바로 ENTITY로 변환되어 저장하면 클라이언트랑 entity가 분리가 안됨 (JSON을 Entity로 바로 바인딩하면 외부 입력이 DB 모델을 직접 건드리게 된다)
// 클라언트랑 entity를 분리해야하는 이유: 보안, 유지보수, 확장성

    @GetMapping("/api/posts")
    public ResponseEntity<List<PostListResponse>> getPosts() {
        List<PostListResponse> posts = postService.getPosts();
        return ResponseEntity.ok(posts);   // DTO -> JSON으로 변환 (스프링 잭슨에서 자동으로 해줌)
        // ResponseEntity는 HTTP 응답(상태/헤더/바디)을 담고, body 객체는 Jackson이 JSON으로 변환한다.
        // 여기선 http상태코드를 ok로 + 응답 body에 posts를 담아서 반환하겠다는 뜻
    }

    @GetMapping("/api/posts/{id}")
    public ResponseEntity<PostDetailResponse> getPostDetail(@PathVariable Long id) {
        PostDetailResponse post = postService.getPostDetail(id);
        return ResponseEntity.ok(post);   // DTO -> JSON으로 변환 / 실제 리턴하는 데이터는 JSON임
    }
}

