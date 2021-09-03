package messageboard.messageboard.controller;

import lombok.RequiredArgsConstructor;
import messageboard.messageboard.domain.BoardCreateRequestDto;
import messageboard.messageboard.domain.BoardListResponseDto;
import messageboard.messageboard.domain.BoardResponseDto;
import messageboard.messageboard.domain.BoardUpdateRequestDto;
import messageboard.messageboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/board/{boardId}")
    public BoardResponseDto searchById(@PathVariable("boardId") Long boardId) {
        return boardService.searchById(boardId);
    }

    @GetMapping("/board")
    public List<BoardListResponseDto> searchAllDesc() {
        return boardService.searchAllDesc();
    }

    @DeleteMapping("/board/{boardId}")
    public void delete(@PathVariable("boardId") Long boardId) {
        boardService.delete(boardId);
    }
}
