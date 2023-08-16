package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   //멤버의 id값을 설정해주고 + sequence값 올려주기
        store.put(member.getId(), member);  //map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //optional로 감싸서 반환해주기(null일 때를 고려)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()   //람다 사용??
                .filter(member -> member.getName().equals(name))
                //member.getName()이 파라미터로 넘어온 name이랑 같은지 확인
                //같은 경우에만 필터링이 된다
                .findAny(); //찾으면 반환
        //루프를 다 돌면서, 하나가 찾아지면 그것을 반환하고
        //끝까지 다 돌았는데 없으면 optional로 null이 반환된다
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //멤버 반환
    }

    public void clearStore(){
        store.clear();
    }

}