package com.hojun.chap5.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.hojun.chap5.domain.Board;

public interface DynamicBoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{

}
