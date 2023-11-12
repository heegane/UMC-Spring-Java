package umc.umcspring.domain;

import lombok.*;
import umc.umcspring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AlarmSetting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private boolean allowNewEventNotification;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private boolean allowReviewReplyNotification;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private boolean allowAskReplyNotification;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
