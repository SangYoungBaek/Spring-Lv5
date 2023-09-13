package com.sparta.lvtwohomework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "boardlike")
@NoArgsConstructor
public class BoardLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boardid", nullable = false)
    private Long boardId;

    @Column(name = "userid", nullable = false)
    private Long userId;

    @Column(name = "boardlike", nullable = false)
    private Boolean boardLike = true;

    public BoardLike(Long boardId, Long userId) {
        this.boardId = boardId;
        this.userId = userId;
    }
}
