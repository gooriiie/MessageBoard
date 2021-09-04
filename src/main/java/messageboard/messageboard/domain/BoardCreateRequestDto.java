package messageboard.messageboard.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardCreateRequestDto {

//    private Member member;
    private String name;
    private String title;
    private String content;

    public BoardCreateRequestDto(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }

//    public Board toEntity() {
//        return Board.builder()
//                .member(member)
//                .title(title)
//                .content(content)
//                .build();
//    }
}
