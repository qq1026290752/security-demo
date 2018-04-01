package cn.yichao.security.config;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
 
@Component
@Slf4j
public class MyUserDetailsServcie implements UserDetailsService,SocialUserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 表单登录
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return buildUser(userName);
	}
	//用户必须要有ROLE_USER 才可以登录 服务提供商
	private SocialUserDetails buildUser(String userId) {
		// 根据用户名查找用户信息
		//根据查找到的用户信息判断用户是否被冻结
		String password = passwordEncoder.encode("123456");
		log.info("数据库密码是:"+password);
		return new SocialUser(userId, password,
				true, true, true, true,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
	}

	/**
	 * social第三方登录
	 */
	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException { 
		return buildUser(userId);
	}

}
