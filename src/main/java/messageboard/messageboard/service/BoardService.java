package messageboard.messageboard.service;

import lombok.RequiredArgsConstructor;
import messageboard.messageboard.domain.Board;
import messageboard.messageboard.domain.BoardCreateRequestDto;
import messageboard.messageboard.domain.BoardUpdateRequestDto;
import messageboard.messageboard.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long create(BoardCreateRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        board.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

}
