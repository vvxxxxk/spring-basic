package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    // @BeforeEach - 각 테스트 실행 전 무조건 실행되는 메서드
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given: ~게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when: ~게 했을 떄
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then: ~게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
