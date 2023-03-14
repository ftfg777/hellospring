package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public interface MemberRepository {
    Member save(Member member);
    /* optional : 널 반환 처리 */
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
