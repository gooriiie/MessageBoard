package messageboard.messageboard.service;

import lombok.RequiredArgsConstructor;
import messageboard.messageboard.domain.*;
import messageboard.messageboard.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long create(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        board.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public BoardResponseDto searchById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new BoardResponseDto(board);
    }

    public List<BoardListResponseDto> searchAllDesc() {
        List<Board> boardList = boardRepository.findAllByOrderByIdDesc();
        List<BoardListResponseDto> boardListResponseDto = new ArrayList<>();
        for (Board board : boardList) {
            boardListResponseDto.add(new BoardListResponseDto(board));
        }

        return boardListResponseDto;

//
//        return boardRepository.findAllByOrderByIdDesc().stream()
//                .map(BoardListResponseDto::new)
//                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        boardRepository.delete(board);
    }
}
