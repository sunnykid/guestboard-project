package kr.goodee.mem;

import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class MemberSvcImpl implements MemberSvc{
	@Autowired
	private MemberRepository repository;
	

	@Override
	public Member member(String mb_id) {
		return repository.findByMbId(mb_id);
	}

	@Override
	public List<Member> list() {
		return (List<Member>)repository.findAll();
	}

	@Override
	public void in(Map<String, Object> param, ModelMap model) {
		System.out.println(param);
		Member mb = new Member();
		mb.setMbId(param.get("mb_id") + "");
		mb.setMbName(param.get("mb_name") + "");
		mb.setMbEmail(param.get("mb_email") + "");
		mb.setMbNickName(param.get("mb_nickname") + "");
		repository.save(mb);
	}

	@Override
	public void up(Map<String, Object> param, ModelMap model) {
		Member mb = member(param.get("mb_id") + "");
		mb.setMbName(mb.getMbName() + "_up");
		mb.setMbEmail(mb.getMbEmail() + "_up");
		mb.setMbNickName(mb.getMbNickName() + "_up");
		repository.save(mb);		
	}

	@Transactional
	@Override
	public void del(Map<String, Object> param) {
		repository.deleteByMbId(param.get("mb_id")+"");
		
	}

}
