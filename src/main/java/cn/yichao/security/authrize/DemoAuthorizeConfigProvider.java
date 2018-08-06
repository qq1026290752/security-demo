package cn.yichao.security.authrize;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import cn.yichao.security.core.authorize.AuthorizeConfigProvider;

@Order(Integer.MAX_VALUE)
@Component
public class DemoAuthorizeConfigProvider implements AuthorizeConfigProvider {

	@Override
	public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		authorizeRequests
				.antMatchers("/user/register","/social/user")
				.permitAll()
				.antMatchers("/hello")
				.hasRole("USER")
				.anyRequest()
			//验证是否存在权限
				.access("@rbacService.hasPermission(request,authentication)");
	}
}
