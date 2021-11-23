package twentyOnes.studyshare.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.todaycomment.TodayComment;
import twentyOnes.studyshare.domain.todaycomment.TodayCommentRepository;
import twentyOnes.studyshare.domain.todolist.TodoList;
import twentyOnes.studyshare.dto.todaycomment.TodayCommentDto;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TodayCommentService {

    private final TodayCommentRepository todayCommentRepository;

    @Transactional
    public Long save(TodayCommentDto todayCommentDto) {
        return todayCommentRepository.save(todayCommentDto.toEntity()).getTodayCommentId();
    }

    @Transactional
    public Optional<TodayCommentDto> findByLocalDate(LocalDate localDate, Long memberId) {
        return todayCommentRepository.findByLocalDateAndMember(localDate, memberId);
    }

    @Transactional
    public Optional<TodayComment> findById(Long id) {
        return todayCommentRepository.findById(id);
    }
}
