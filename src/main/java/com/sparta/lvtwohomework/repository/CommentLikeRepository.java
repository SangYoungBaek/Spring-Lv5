package com.sparta.lvtwohomework.repository;

import com.sparta.lvtwohomework.entity.BoardLike;
import com.sparta.lvtwohomework.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

    Optional<CommentLike> findByCommentIdAndUserId(Long commentId, Long id);

    CommentLike findByUserId(Long id);

}
