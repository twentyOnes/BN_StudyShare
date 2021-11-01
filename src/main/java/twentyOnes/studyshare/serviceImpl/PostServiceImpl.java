package twentyOnes.studyshare.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twentyOnes.studyshare.domain.posts.Post;
import twentyOnes.studyshare.domain.posts.PostRepository;
import twentyOnes.studyshare.dto.posts.PostUpdateRequestDto;

import java.util.List;
import twentyOnes.studyshare.service.PostService;


@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //글 목록 로직
    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    //하나의 게시물 불러오기
    @Override
    @Transactional(readOnly = true)
    public Post detail(Long id) {
        return this.postRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 포스트가 없습니다. id" + id));
    }

    //게시물 업데이트
    //findById로 Post를 영속화 -> 영속성 컨텍스트에 Post 객체가 담겨진다.
    //그 후 Post의 값을 변경시키면 Service가 종료되는 시점에 트랜잭션이 종료되고 더티 체킹이 일어난다.
    @Override
    @Transactional
    public Long update(Long id, PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 포스트가 없습니다. id" + id));
        post.update(postUpdateRequestDto.getPostText());
        return id;
    }

    //게시물 삭제하기
    @Override
    @Transactional
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

}

