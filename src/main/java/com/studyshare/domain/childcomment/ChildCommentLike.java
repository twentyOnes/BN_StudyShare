package com.studyshare.domain.childcomment;

import com.studyshare.domain.Like;

import javax.persistence.*;

@Entity
@DiscriminatorValue("chi")
public class ChildCommentLike extends Like {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_comment_id")
    private ChildComment childComment;

}