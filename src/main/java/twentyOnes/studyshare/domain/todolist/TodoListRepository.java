package twentyOnes.studyshare.domain.todolist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    Optional<TodoList> findByLocalDate(LocalDate localDate);
}
