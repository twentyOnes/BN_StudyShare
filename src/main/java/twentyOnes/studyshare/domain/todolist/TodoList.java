package twentyOnes.studyshare.domain.todolist;

import lombok.Builder;
import twentyOnes.studyshare.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long todoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "todo_subject")
    private String todoSubject;

    @Column(name = "todo_text")
    private String todoText;

    @Column(name = "today_date")
    private LocalDate localDate;

    @Column(name = "study_time")
    private String studyTime;

    @Enumerated(EnumType.STRING)
    private Achievement achievement;

    @Builder
    public TodoList(Member member, String todoSubject, String todoText, LocalDate localDate, String studyTime, Achievement achievement) {
        this.member = member;
        this.todoSubject = todoSubject;
        this.todoText = todoText;
        this.localDate = localDate;
        this.studyTime = studyTime;
        this.achievement = achievement;
    }
}
