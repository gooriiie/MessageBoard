package messageboard.messageboard.domain;

public class BoardListResponseDto {

    private Long id;
    private String name;
    private String title;

    public BoardListResponseDto(Board board) {
        this.id = board.getId();
        this.name = board.getMember().getName();
        this.title = board.getTitle();
    }
}
