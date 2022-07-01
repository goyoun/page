package com.example.page.repository;

import com.example.page.entity.Board;
import com.example.page.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByUserOrderByIdDesc(User user, Pageable pageable);

}
