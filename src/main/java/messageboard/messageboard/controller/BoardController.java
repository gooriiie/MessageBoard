package messageboard.messageboard.controller;

import lombok.RequiredArgsConstructor;
import messageboard.messageboard.domain.*;
import messageboard.messageboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/new")
    public String createForm(Model model) {
        model.addAttribute("writeForm", new BoardCreateRequestDto());
        return "board/writeForm";
    }

    @PostMapping("/board/register")
    public String create(BoardCreateRequestDto boardCreateRequestDto) {
        Board board = new Board();
        board.setName(boardCreateRequestDto.getName());
        board.setTitle(boardCreateRequestDto.getTitle());
        board.setContent(boardCreateRequestDto.getContent());

        boardService.create(board);

        return "redirect:/board";
    }

    @GetMapping("/board")
    public String searchAllDesc(Model model) {
        List<BoardListResponseDto> boardListResponseDto = boardService.searchAllDesc();
        model.addAttribute("boardListResponseDto", boardListResponseDto);
        return "board/list";
    }

    @PutMapping("/board/{boardId}")
    public Long update(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateRequestDto requestDto) {

        return boardService.update(boardId, requestDto);
    }

    @GetMapping("/board/{boardId}")
    public BoardResponseDto searchById(@PathVariable("boardId") Long boardId) {
        return boardService.searchById(boardId);
    }


    @DeleteMapping("/board/{boardId}")
    public void delete(@PathVariable("boardId") Long boardId) {
        boardService.delete(boardId);
    }
}
