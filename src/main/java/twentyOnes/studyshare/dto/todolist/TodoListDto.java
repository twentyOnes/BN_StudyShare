package twentyOnes.studyshare.dto.todolist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.todolist.Achievement;
import twentyOnes.studyshare.domain.todolist.TodoList;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TodoListDto {

    private Member member;
    private String todoSubject;
    private String todoText;
    private LocalDate localDate;
    private String studyTime;

    @Enumerated(EnumType.STRING)
    private Achievement achievement;

    @Builder
    public TodoListDto(Member member, String todoSubject, String todoText, LocalDate localDate, String studyTime, Achievement achievement) {
        this.member = member;
        this.todoSubject = todoSubject;
        this.todoText = todoText;
        this.localDate = localDate;
        this.studyTime = studyTime;
        this.achievement = achievement;
    }

    public TodoList toEntity() {
        return TodoList.builder()
                .member(member)
                .todoSubject(todoSubject)
                .todoText(todoText)
                .localDate(localDate)
                .studyTime(studyTime)
                .achievement(achievement)
                .build();
    }
}
