package twentyOnes.studyshare.domain.posts;

import twentyOnes.studyshare.domain.Like;

import javax.persistence.*;

@Entity
@DiscriminatorValue("pos")
public class PostLike extends Like {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
