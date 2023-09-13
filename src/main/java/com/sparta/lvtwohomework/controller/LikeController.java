package com.sparta.lvtwohomework.controller;

import com.sparta.lvtwohomework.dto.StatusResponseDto;
import com.sparta.lvtwohomework.security.UserDetailsImpl;
import com.sparta.lvtwohomework.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/like/board/{boardId}")
    public StatusResponseDto createLikeBoard(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return likeService.createLikeBoard(boardId, userDetails.getUser());
    }

    @PostMapping("/like/comment/{boardId}/{commentId}")
    public StatusResponseDto createLikeComment(@PathVariable Long boardId, @PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likeService.createLikeComment(boardId, commentId, userDetails.getUser());
    }
}
