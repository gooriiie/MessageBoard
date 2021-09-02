package messageboard.messageboard.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardUpdateRequestDto {

    private String title;
    private String content;

    @Builder
    public BoardUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
