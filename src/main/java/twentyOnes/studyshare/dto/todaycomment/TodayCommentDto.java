package twentyOnes.studyshare.dto.todaycomment;

import lombok.Builder;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.todaycomment.TodayComment;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class TodayCommentDto {

    private Member member;
    private String todayCommentTitle;
    private String todayCommentText;
    private LocalDate localDate;

    @Builder
    public TodayCommentDto(Member member, String todayCommentTitle, String todayCommentText, LocalDate localDate) {
        this.member = member;
        this.todayCommentTitle = todayCommentTitle;
        this.todayCommentText = todayCommentText;
        this.localDate = localDate;
    }

    public TodayComment toEntity() {
        return TodayComment.builder()
                .member(member)
                .todayCommentTitle(todayCommentTitle)
                .todayCommentText(todayCommentText)
                .localDate(localDate)
                .build();
    }
}
