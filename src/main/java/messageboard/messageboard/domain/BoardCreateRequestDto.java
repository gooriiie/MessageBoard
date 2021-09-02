package messageboard.messageboard.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardCreateRequestDto {

    private Member member;
    private String title;
    private String content;

    @Builder
    public BoardCreateRequestDto(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}
