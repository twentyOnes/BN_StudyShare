package twentyOnes.studyshare.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.dto.member.MemberDto;
import twentyOnes.studyshare.service.FollowService;
import twentyOnes.studyshare.service.MemberService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api(tags = {"Member API"})
public class MemberController {

    private final MemberService memberService;
    private final FollowService followService;

    @GetMapping("/hello")
    public String hello () {
        return "hello";
    }

    @PostMapping("/join")
    @ApiOperation(value = "회원가입", notes = "회원가입을 위한 API")
    public ResponseEntity<Member> signup(
            @Valid @RequestBody MemberDto memberDto
    ) {
        return ResponseEntity.ok(memberService.signup(memberDto));
    }

    @GetMapping("/member")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @ApiOperation(value = "회원 본인 조회", notes = "회원 본인 정보 조회를 위한 API")
    public ResponseEntity<Member> getMyUserInfo() {
        return ResponseEntity.ok(memberService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/member/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "원하는 회원조회", notes = "원하는 회원 정보 조회를 위한 API")
    public ResponseEntity<Member> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(memberService.getUserWithAuthorities(username).get());
    }
}