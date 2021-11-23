package twentyOnes.studyshare.domain.todaycomment;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.todolist.TodoList;
import twentyOnes.studyshare.dto.todaycomment.TodayCommentDto;

import java.time.LocalDate;
import java.util.Optional;

public interface TodayCommentRepository extends JpaRepository<TodayComment, Long> {

    Optional<TodayCommentDto> findByLocalDateAndMember(LocalDate localDate, Long memberId);
}
