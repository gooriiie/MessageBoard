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

    @PostMapping("/board/new")
    public String create(BoardCreateRequestDto boardCreateRequestDto) {
        Board board = new Board();
        board.setMember(boardCreateRequestDto.getMember());
        board.setTitle(boardCreateRequestDto.getTitle());
        board.setContent(boardCreateRequestDto.getContent());

        boardService.create(board);

        return "redirect:/";
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
