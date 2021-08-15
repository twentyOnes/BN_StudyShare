package twentyOnes.studyshare.domain.comment;

import twentyOnes.studyshare.domain.Like;

import javax.persistence.*;

@Entity
@DiscriminatorValue("com")
public class CommentLike extends Like {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
