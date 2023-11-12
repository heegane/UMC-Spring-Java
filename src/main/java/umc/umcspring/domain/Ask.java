package umc.umcspring.domain;

import lombok.*;
import umc.umcspring.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Ask extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "ask", cascade = CascadeType.ALL)
    private List<AskImage> askImageList = new ArrayList<>();

    @OneToMany(mappedBy = "ask", cascade = CascadeType.ALL)
    private List<AskReply> askReplyList = new ArrayList<>();
}
