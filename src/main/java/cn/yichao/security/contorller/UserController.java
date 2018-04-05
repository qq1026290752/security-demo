package cn.yichao.security.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import cn.yichao.security.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private ProviderSignInUtils providerSignInUtils;
	 @Autowired(required = false)
	/*private AppSignInUtils  appSignInUtils; */
	
	@PostMapping(value = "/register")
	public void register(User user,HttpServletRequest request) {
		//TODO:用户注册
		String userId = user.getUsername();
		//appSignInUtils.doPostSignUp(new ServletWebRequest(request), userId);
		providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
	}

}
