package com.htm.backend.repository;

import com.htm.backend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {   // 제네릭형태의 인터페이스를 상속
    // 스프링은 여기 안의 메서드 이름을 해석해서 실제 메서드를 자동으로 만들어줌 (소원비는곳)
}

//public interface JpaRepository<T, ID> {   이렇게 생김
//    T save(T entity);    // T 타입을 반환하는 save함수, 파라미터도 T타입
//    Optional<T> findById(ID id);    // T타입인데 있을수도 있고 없을수도 있음
//    List<T> findAll();          // T타입 리스트 반환
//    void deleteById(ID id);
//    ...
//}

