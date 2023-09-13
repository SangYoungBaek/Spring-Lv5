package com.sparta.lvtwohomework.dto;

import com.sparta.lvtwohomework.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String contents;
    private String username;
    private Long likeCount;
    private LocalDateTime saveDate;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment saveComment) {
        this.id = saveComment.getId();
        this.contents = saveComment.getContents();
        this.username = saveComment.getUsername();
        this.likeCount = saveComment.getLikeCount();
        this.saveDate = saveComment.getSaveDate();
        this.modifiedAt = saveComment.getModifiedAt();
    }
}
