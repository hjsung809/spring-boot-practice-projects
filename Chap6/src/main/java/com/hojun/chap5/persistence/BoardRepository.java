package com.hojun.chap5.persistence;

import org.springframework.data.repository.CrudRepository;

import com.hojun.chap5.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
