package com.studyshare.domain.posts;

import com.studyshare.domain.Like;

import javax.persistence.*;

@Entity
@DiscriminatorValue("pos")
public class PostLike extends Like {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
