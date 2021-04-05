package com.hojun.chap5.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hojun.chap5.domain.Member;
import com.hojun.chap5.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService{
	@Autowired
	MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Member> optional = memberRepo.findById(username);
		
		if(optional.isPresent()) {
			Member member = optional.get();
			return new SecurityUser(member);
		} else {
			throw new UsernameNotFoundException(username + " 사용자 없음");
		}
	}

}
