package com.sparta.lvtwohomework.service;

import com.sparta.lvtwohomework.dto.StatusResponseDto;
import com.sparta.lvtwohomework.entity.*;
import com.sparta.lvtwohomework.repository.BoardLikeRepository;
import com.sparta.lvtwohomework.repository.BoardRepository;
import com.sparta.lvtwohomework.repository.CommentLikeRepository;
import com.sparta.lvtwohomework.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {
    private final CommentLikeRepository commentLikeRepository;
    private final BoardLikeRepository boardLikeRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public StatusResponseDto createLikeBoard(Long boardId, User user) {
        System.out.println("여기 아이디임 " + user.getId());
        Board board = boardRepository.findById(boardId).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );
        Optional<BoardLike> boardLikeChk = boardLikeRepository.findByBoardIdAndUserId(boardId, user.getId());
        BoardLike boardLike = boardLikeRepository.findByUserId(user.getId());

        if(!boardLikeChk.isPresent()){
            board.setLikeCount(board.getLikeCount() + 1);
            boardLikeRepository.save(new BoardLike(boardId, user.getId()));
        } else if(!boardLike.getBoardLike()){
            board.setLikeCount(board.getLikeCount() + 1);
            boardLike.setBoardLike(!boardLike.getBoardLike());
        } else {
            board.setLikeCount(board.getLikeCount() - 1);
            boardLike.setBoardLike(!boardLike.getBoardLike());
        }

        return new StatusResponseDto(String.valueOf(HttpStatus.OK), "게시글 좋아요 성공");
    }

    public StatusResponseDto createLikeComment(Long boardId, Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->
                new IllegalArgumentException("해당 댓글은 존재하지 없습니다.")
        );

        Optional<CommentLike> commentLikeChk = commentLikeRepository.findByCommentIdAndUserId(commentId, user.getId());
        CommentLike commentLike = commentLikeRepository.findByUserId(user.getId());

        if(!commentLikeChk.isPresent()){
            comment.setLikeCount(comment.getLikeCount() + 1);
            commentLikeRepository.save(new CommentLike(boardId, commentId, user.getId()));
        } else if(!commentLike.getCommentLike()) {
            comment.setLikeCount(comment.getLikeCount() + 1);
            commentLike.setCommentLike(!commentLike.getCommentLike());
        } else {
            comment.setLikeCount(comment.getLikeCount() - 1);
            commentLike.setCommentLike(!commentLike.getCommentLike());
        }

        return new StatusResponseDto(String.valueOf(HttpStatus.OK), "댓글 좋아요 성공");
    }
}
