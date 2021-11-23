package twentyOnes.studyshare.domain.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.dto.todolist.TodoListDto;

import java.time.LocalDate;
import java.util.Optional;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    Optional<TodoListDto> findByLocalDateAndMember(LocalDate localDate, Long memberId);
}
