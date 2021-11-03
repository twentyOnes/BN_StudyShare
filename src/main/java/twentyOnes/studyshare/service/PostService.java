package twentyOnes.studyshare.service;

import org.springframework.stereotype.Service;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.posts.Post;
import twentyOnes.studyshare.dto.posts.PostSaveRequestDto;
import twentyOnes.studyshare.dto.posts.PostUpdateRequestDto;

import java.util.List;


@Service
public interface PostService {
    List<Post> findAll();
    Post detail(Long id);
    Long save(PostSaveRequestDto postSaveRequestDto, Member member);
    Long update(Long id, PostUpdateRequestDto postUpdateRequestDto);
    void deleteById(Long id);
}
