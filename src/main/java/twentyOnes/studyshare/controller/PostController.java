package twentyOnes.studyshare.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twentyOnes.studyshare.domain.posts.Post;
import twentyOnes.studyshare.dto.posts.PostUpdateRequestDto;
import twentyOnes.studyshare.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = {"Post API"})
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> detail(@PathVariable Long id) {
        return ResponseEntity.ok(postService.detail(id));
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.update(id, postUpdateRequestDto);

    }

    @DeleteMapping("api/v1/posts/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
