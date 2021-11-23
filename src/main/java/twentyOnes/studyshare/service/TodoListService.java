package twentyOnes.studyshare.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.todolist.TodoList;
import twentyOnes.studyshare.domain.todolist.TodoListRepository;
import twentyOnes.studyshare.dto.todolist.TodoListDto;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;

    @Transactional
    public Long save(TodoListDto todoListDto) {
        return todoListRepository.save(todoListDto.toEntity()).getTodoId();
    }

    @Transactional
    public Optional<TodoListDto> findByLocalDate(LocalDate localDate, Long memberId) {
        return todoListRepository.findByLocalDateAndMember(localDate, memberId);
    }
}
