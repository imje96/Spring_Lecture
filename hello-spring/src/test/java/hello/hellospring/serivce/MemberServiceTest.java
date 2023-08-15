package hello.hellospring.serivce;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    // test에서 하는 메모리 객체는 다른 객체임 beforeEach로 위의 MemberService에 repository를 넣어줌
    // 외부에서 넣어주는 것 Depency Injection
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // clear 돌 때마다 db의 값을 날려줌
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
   // given
        Member member = new Member();
        member.setName("hello");

   // when
        Long saveId = memberService.join(member);

   // then
        Member findMember = memberService.findOne(saveId).get();
//        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
// 이거 안됨       assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // when

    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//    assertThrows(NullPointerException.class, () -> memberService.join(member2)); // fail
    assertEquals(e.getMessage(),("이미 존재하는 회원입니다.")); // ok

    /*
        try{
        memberService.join(member2);
        fail();
    } catch (IllegalStateException e){
        assertEquals(e.getMessage(),("이미 존재하는 회원입니다.")); // ok
//        assertEquals(e.getMessage(),("이미 존재하는 회원입니다.123")); // fail
    }

*/

            //
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}