package com.hojun.chap5.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude="boardList")
public class Member {
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
	
}
