package twentyOnes.studyshare.domain.todaycomment;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyOnes.studyshare.domain.todolist.TodoList;

import java.time.LocalDate;
import java.util.Optional;

public interface TodayCommentRepository extends JpaRepository<TodayComment, Long> {

    Optional<TodayComment> findByLocalDate(LocalDate localDate);
}
