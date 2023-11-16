package com.itwill.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	List<Board> findByStepGreaterThanAndGroupno(Long step,Long groupNo);
	List<Board> findByBoardnoGreaterThanEqualOrderByGroupnoDescStepAsc(Long boardNo);
	//Page<Board> findByBoardnoGreaterThanEqualOrderByGroupnoDescStepAsc(Long boardNo,Pageable pageable);
	
}
