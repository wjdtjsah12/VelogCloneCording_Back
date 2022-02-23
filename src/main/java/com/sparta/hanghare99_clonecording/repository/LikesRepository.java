package com.sparta.hanghare99_clonecording.repository;

import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Likes;
import com.sparta.hanghare99_clonecording.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findAllByBoard(Board board);

    Optional<Likes> findByBoardAndUser(Board board, User user);
}
