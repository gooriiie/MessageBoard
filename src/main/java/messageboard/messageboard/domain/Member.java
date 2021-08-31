package messageboard.messageboard.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.common.reflection.XMember;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(length = 13)
    private String contact;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public Member(String name, String password, String email, String contact) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }
}
