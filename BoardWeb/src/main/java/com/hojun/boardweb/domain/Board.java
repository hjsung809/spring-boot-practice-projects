package com.hojun.boardweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude="member")
@Entity
public class Board {
	@Id @GeneratedValue
	private Long seq;
	
	private String title;

	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createDate = new Date();
	
	@Column(updatable=false)
	private Long cnt = 0L;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false) // 쪼인 설정. inner join으로 변경.
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this); // 보드의 주인을 설정할때, 주인인 멤버에도 추가해준다.
	}
}
