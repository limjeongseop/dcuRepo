package kr.ac.cu.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.cu.user.model.vo.UserVO;
import kr.ac.cu.user.service.UserService;

@Controller
public class UserCtrl {
	
	@Resource(name="userS")
	private UserService service ; 
	
	@RequestMapping("/index.dcu")
	public String main() {
		return "index" ; 	
	}
	
	@RequestMapping("/login.dcu")
	public String login(UserVO user, HttpSession session) {
		System.out.println("ctrl login user : "+user);
		UserVO result = service.login(user) ; 
		//String path = "error" ; 
		String path = "redirect:/xxxxx.dcu" ;
		if(result !=  null) {
			session.setAttribute("loginSession", result) ; 
			//path = "index";
			path = "redirect:/index.dcu";
		}
		return path ; 	
	}
	
	@RequestMapping("/logout.dcu")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/index.dcu" ; 	
	}
	
	@RequestMapping("/ajax.dcu")
	@ResponseBody
	public UserVO ajax() {
		System.out.println("ctrl ajax"); 
		UserVO result = new UserVO();
		result.setId("jslim"); result.setPwd("jslim");
		return result ; 	
	}
	
}









