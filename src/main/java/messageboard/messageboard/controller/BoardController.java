package messageboard.messageboard.controller;

import lombok.RequiredArgsConstructor;
import messageboard.messageboard.domain.BoardCreateRequestDto;
import messageboard.messageboard.domain.BoardUpdateRequestDto;
import messageboard.messageboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public Long create(@RequestBody BoardCreateRequestDto requestDto) {
        return boardService.create(requestDto);
    }

    @PutMapping("/board/{boardId}")
    public Long update(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(boardId, requestDto);
    }
}
