package com.studyshare.domain.member;

import com.studyshare.domain.childcomment.ChildComment;
import com.studyshare.domain.Like;
import com.studyshare.domain.todaycomment.TodayComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @Column(name = "member_id", length = 50)
    private Long memberId;

    private String id;

    private String password;

    @Column(name = "nickname")
    private String nickname;

    private String email;

    @Column(name = "member_image")
    private String memberImage;

    @Column(name = "follower_count")
    private int followerCount;

    @Column(name = "followee_count")
    private int followeeCount;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<ChildComment> childCommentList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Like> likeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<TodayComment> todayCommentList = new ArrayList<>();
}
