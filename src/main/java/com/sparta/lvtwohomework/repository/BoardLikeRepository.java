package com.sparta.lvtwohomework.repository;

import com.sparta.lvtwohomework.entity.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {

    BoardLike findByUserId(Long id);

    Optional<BoardLike> findByBoardIdAndUserId(Long boardId, Long id);

}
