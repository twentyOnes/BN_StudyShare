package twentyOnes.studyshare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import twentyOnes.studyshare.domain.todaycomment.TodayComment;
import twentyOnes.studyshare.dto.todaycomment.TodayCommentDto;
import twentyOnes.studyshare.service.TodayCommentService;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class TodayCommentController {

    private TodayCommentService todayCommentService;

    @PostMapping("/todolist")
    public Long saveTodayComment(@RequestBody TodayCommentDto todayCommentDto) {
        return todayCommentService.save(todayCommentDto);
    }

    @GetMapping("/todolist")
    public ResponseEntity<TodayComment> getTodayComment(LocalDate localDate) {
        return ResponseEntity.ok(todayCommentService.findByLocalDate(localDate).get());
    }
}
