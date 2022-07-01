package com.example.page.dto;

import com.example.page.entity.Board;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class BoardResponseDTO {

    private final Long id;
    private final String username;
    private final String title;
    private final String content;

    public static BoardResponseDTO from(Board board) {
        return BoardResponseDTO.builder()
                .id(board.getId())
                .username(board.getUser().getName())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

}
