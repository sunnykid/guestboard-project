package kr.goodee.mem;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MemberController {
	@Autowired
	private MemberSvc scv;

	@GetMapping
	public String memberList(@RequestParam Map<String,Object> param, ModelMap model) {
		List<Member> list = (List<Member>)scv.list();
		model.put("memberlist",list);
		return "memberlist";
	}	
	@PostMapping("in")
	public String in(@RequestParam Map<String,Object> param, ModelMap model) {
		System.out.println(param);
		System.out.println(model);
		
		scv.in(param,model);
		return "redirect:/";
	}
	@GetMapping("del")
	public String del(@RequestParam Map<String,Object> param) {
		scv.del(param);
		return "redirect:/";
	}	
}
