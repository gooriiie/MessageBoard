package messageboard.messageboard.domain;

import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private String name;
    private String title;
    private String content;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.name = board.getMember().getName();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

}
