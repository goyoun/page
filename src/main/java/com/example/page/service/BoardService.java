package com.example.page.service;

import com.example.page.dto.BoardResponseDTO;
import com.example.page.entity.Board;
import com.example.page.entity.User;
import com.example.page.repository.BoardRepository;
import com.example.page.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import static com.example.page.entity.User.createUser;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = userRepository.save(
                User.builder()
                        .email("gogo@gogo@com")
                        .name("gogo")
                        .build());
        for (int i = 1; i <= 25; ++i) {
            boardRepository.save(
                    Board.builder()
                            .title("제목" + i)
                            .content("내용" + i)
                            .user(user).build());
        }
    }

    public Page<BoardResponseDTO> findAll(Pageable pageable) {
        return boardRepository.findByUserOrderByIdDesc(createUser(), pageable)
                .map(BoardResponseDTO::from);
    }

}
