package kr.goodee.mem;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository 상속받은 경우 findBy, findAll등 기본 사용 가능
public interface MemberRepository extends JpaRepository<Member,Long>{
	Member findByMbId(String mb_id);
	void deleteByMbId(String mb_id);
}
