package com.example.page.controller;

import com.example.page.dto.BoardResponseDTO;
import com.example.page.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public List<BoardResponseDTO> find(@PageableDefault(size = 7) Pageable pageable) {
        return boardService.findAll(pageable).getContent();
    }

}
