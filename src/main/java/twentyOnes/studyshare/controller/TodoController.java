package twentyOnes.studyshare.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.todaycomment.TodayComment;
import twentyOnes.studyshare.dto.todaycomment.TodayCommentDto;
import twentyOnes.studyshare.dto.todolist.TodoListDto;
import twentyOnes.studyshare.service.MemberService;
import twentyOnes.studyshare.service.TodayCommentService;
import twentyOnes.studyshare.service.TodoListService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private TodoListService todoListService;
    private TodayCommentService todayCommentService;
    private MemberService memberService;

    @PostMapping("/todolist")
    public Long saveTodoList(@RequestBody TodoListDto todoListDto) {
        return todoListService.save(todoListDto);
    }

    @PostMapping("/todaycomment")
    public Long saveTodayComment(@RequestBody TodayCommentDto todayCommentDto) {
        return todayCommentService.save(todayCommentDto);
    }

    @GetMapping("/todaycomment")
    public ResponseEntity<TodayCommentDto> getTodayComment(Long memberId, LocalDate localDate) {
        return ResponseEntity.ok(todayCommentService.findByLocalDate(localDate, memberId).orElse(createTc(memberId, localDate)));
    }

    @GetMapping("/todolist")
    public ResponseEntity<TodoListDto> getTodolist(Long memberId, LocalDate localDate) {
        return ResponseEntity.ok(todoListService.findByLocalDate(localDate, memberId).orElse(createTl(memberId, localDate)));
    }

    private TodayCommentDto createTc(Long memberId, LocalDate localDate) {
        TodayCommentDto todayCommentDto = new TodayCommentDto(memberService.getUserById(memberId).get(), null, null, localDate);
        Long id = todayCommentService.save(todayCommentDto);

        return todayCommentDto;
    }

    private TodoListDto createTl(Long memberId, LocalDate localDate) {
        TodoListDto todoListDto = new TodoListDto(memberService.getUserById(memberId).get(), null, null, localDate, null, null);
        Long id = todoListService.save(todoListDto);

        return todoListDto;
    }
}
