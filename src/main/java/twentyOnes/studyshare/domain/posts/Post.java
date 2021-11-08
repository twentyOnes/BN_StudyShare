package twentyOnes.studyshare.domain.posts;

import twentyOnes.studyshare.domain.comment.Comment;
import twentyOnes.studyshare.domain.hashtag.Tag;
import twentyOnes.studyshare.domain.hashtag.TagPost;
import twentyOnes.studyshare.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "post_text")
    private String postText;

    @Column(name = "post_image")
    private String postImage;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "comment_count")
    private int commentCount;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<TagPost> tagPostList = new ArrayList<>();

    //update 메서드 추가
    //JPA에서 update 진행 시 영속성 컨텍스트에 있는 값과 비교하여 변경된 값이 있으면 그 변경된 값만 update 시킨다.
    // -> 더티 체킹 및 변경 감지
    public void update(String postText) {
        this.postText = postText;
    }
}