package com.sparta.lvtwohomework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "commentlike")
@NoArgsConstructor
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commentid", nullable = false)
    private Long commentId;

    @Column(name = "userid", nullable = false)
    private Long userId;

    @Column(name = "commentlike", nullable = false)
    private Boolean commentLike = true;

    @Column(name = "boardId", nullable = false)
    private Long boardId;

    public CommentLike(Long boardId, Long commentId, Long userId) {
        this.boardId = boardId;
        this.commentId = commentId;
        this.userId = userId;
    }

}
