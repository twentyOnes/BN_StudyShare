package twentyOnes.studyshare.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.posts.Post;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveRequestDto {
    private Member member;
    private String postText;
    private String postImage;
    private int likeCount;
    private int commentCount;

    public Post toEntity() {
        return Post.builder()
                .member(member)
                .postText(postText)
                .postImage(postImage)
                .likeCount(0)
                .commentCount(0)
                .build();
    }
    public void setMember(Member member) {
        this.member = member;
    }
}
