package twentyOnes.studyshare.domain.childcomment;

import twentyOnes.studyshare.domain.Like;

import javax.persistence.*;

@Entity
@DiscriminatorValue("chi")
public class ChildCommentLike extends Like {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_comment_id")
    private ChildComment childComment;

}