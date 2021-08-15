package com.studyshare.domain.comment;

import com.studyshare.domain.Like;

import javax.persistence.*;

@Entity
@DiscriminatorValue("com")
public class CommentLike extends Like {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
