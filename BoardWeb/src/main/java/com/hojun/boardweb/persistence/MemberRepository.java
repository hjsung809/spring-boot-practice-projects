package com.hojun.boardweb.persistence;

import org.springframework.data.repository.CrudRepository;

import com.hojun.boardweb.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{

}
