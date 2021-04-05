package com.hojun.chap5.persistence;

import org.springframework.data.repository.CrudRepository;

import com.hojun.chap5.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
	
}
