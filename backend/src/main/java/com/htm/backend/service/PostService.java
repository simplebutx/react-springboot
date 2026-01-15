package com.htm.backend.service;

import com.htm.backend.domain.Post;
import com.htm.backend.dto.PostCreateRequest;
import com.htm.backend.dto.PostDetailResponse;
import com.htm.backend.dto.PostListResponse;
import com.htm.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service   // 비즈니스 로직의 집합소 (컨트롤러는 호출만 함)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long createPost(PostCreateRequest dto) {     // 이런 함수를 만들어서 여기서 책임 / 컨트롤러는 호출만 담당함
        Post post = new Post(dto.getTitle(), dto.getContent());   // 외부에서 들어온 데이터(DTO)를 -> entity로 변환
        Post saved = postRepository.save(post);   // 저장 요청
        return saved.getId();
    }

    public List<PostListResponse> getPosts() {
        return postRepository.findAll()
                .stream()   // List를 Stream으로 변환 (리스트를 하나씩 처리할 수 있게 풀어주는 것)
                .map(post -> new PostListResponse(post.getId(), post.getTitle(), post.getContent()))  // entity를 -> DTO로 변환
                .toList();    // 최종적으로 List<PostListResponse>가 됨
    }

    public PostDetailResponse getPostDetail(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("게시글없음"));

        return new PostDetailResponse(post.getId(), post.getTitle(), post.getContent());  // entity를 -> DTO로 변환
    }
}
