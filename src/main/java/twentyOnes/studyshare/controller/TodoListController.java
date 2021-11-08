package twentyOnes.studyshare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twentyOnes.studyshare.domain.todolist.TodoList;
import twentyOnes.studyshare.service.TodoListService;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class TodoListController {

    private TodoListService todoListService;

    @GetMapping("/todolist")
    public ResponseEntity<TodoList> getTodolist(LocalDate localDate) {
        return ResponseEntity.ok(todoListService.findByLocalDate(localDate).get());
    }
}
