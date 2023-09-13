package com.sparta.lvtwohomework.dto;

import lombok.Getter;

@Getter
public class StatusResponseDto {
    private String status;
    private String msg;

    public StatusResponseDto(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
