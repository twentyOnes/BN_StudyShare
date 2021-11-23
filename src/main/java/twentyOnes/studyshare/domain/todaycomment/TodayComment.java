package twentyOnes.studyshare.domain.todaycomment;

import lombok.Builder;
import twentyOnes.studyshare.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import twentyOnes.studyshare.dto.todaycomment.TodayCommentDto;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class TodayComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "today_comment_id")
    private Long todayCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "today_comment_title")
    private String todayCommentTitle;

    @Column(name = "today_comment_text")
    private String todayCommentText;

    @Column(name = "today_datetime", columnDefinition = "TIMESTAMP")
    private LocalDate localDate;

    public TodayComment(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Builder
    public TodayComment(Member member, String todayCommentTitle, String todayCommentText, LocalDate localDate) {
        this.member = member;
        this.todayCommentTitle = todayCommentTitle;
        this.todayCommentText = todayCommentText;
        this.localDate = localDate;
    }
}
