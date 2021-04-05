package com.hojun.chap5.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hojun.chap5.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	Page<Board> findByTitleContaining(String content, Pageable paging);
	
	// JPQL이므로, 테이블 이름이 아닌, 엔티티 이름을 사용해야 한다.
//	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(@Param("searchKeyword")String searchKeyword);
//	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(String searchKeyword);
//	
//	@Query(value="SELECT seq, title, writer, create_date FROM board WHERE title like '%'||?1||'%' ORDER BY seq DESC", nativeQuery=true)
//	List<Object[]> queryAnnotationTest3(String searchKeyword);
//	
//	@Query("SELECT b FROM Board b")
//	List<Board> queryAnnotationTest4(Pageable paging);
}
