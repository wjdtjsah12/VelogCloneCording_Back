package com.sparta.hanghare99_clonecording.repository;

import com.sparta.hanghare99_clonecording.model.Board_Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Board_TagRepository extends JpaRepository<Board_Tag,Long> {
    List<Board_Tag> findByBoard_Id(Long board_Id);
}
