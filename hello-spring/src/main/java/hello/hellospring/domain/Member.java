package hello.hellospring.domain;
// 회원 도메인과 레포지터리 만들기
public class Member {
    private Long id; //시스템이 저장하는 아이디
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


