package messageboard.messageboard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class BoardListResponseDto {

    private Long id;
    private String name;
    private String title;

    public BoardListResponseDto(Board board) {
        this.id = board.getId();
        this.name = board.getName();
        this.title = board.getTitle();
    }
}
