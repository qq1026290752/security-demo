package cn.yichao.security.contorller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yichao.security.core.properties.SecurityPeoperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
public class IndexController {
	
	@Autowired
	private SecurityPeoperties securityPeoperties;
	
	@GetMapping("")
	public String toIndex() {
		return "index";
	}
		
	@GetMapping("/me")
	public Object getCurrentUser(Authentication user,HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String toke = StringUtils.substringAfter(header, "bearer ");
		//验证签名
		Claims body = Jwts.parser().setSigningKey(securityPeoperties.getOauth2().getOAuth2SigningKey()).parseClaimsJws(toke)
			.getBody();
		return body;
	}
/*	@GetMapping("/me")
	public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
		return user;
	}
*/
}
