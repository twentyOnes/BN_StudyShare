package twentyOnes.studyshare.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twentyOnes.studyshare.domain.todolist.TodoList;
import twentyOnes.studyshare.domain.todolist.TodoListRepository;
import twentyOnes.studyshare.dto.todolist.TodoListDto;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoListService {
    private TodoListRepository todoListRepository;

    @Transactional
    public Long save(TodoListDto todoListDto) {
        return todoListRepository.save(todoListDto.toEntity()).getTodoId();
    }

    @Transactional
    public Optional<TodoList> findByLocalDate(LocalDate localDate) {
        return todoListRepository.findByLocalDate(localDate);
    }
}
