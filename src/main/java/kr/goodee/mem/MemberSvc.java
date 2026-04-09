package kr.goodee.mem;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

public interface MemberSvc {
	Member member(String mb_id);
	List<Member> list();
	void in (Map<String,Object> param,ModelMap model);
	void up (Map<String,Object> param,ModelMap model);
	void del (Map<String,Object> param);
}
