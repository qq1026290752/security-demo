package cn.yichao.security.social;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;
/**
 * 默认无需登陆系统自动创建账号
 * @author w4837
 *
 */
@Component("connectionSignUp")
public class DemoConnectionSignUp implements ConnectionSignUp {

	@Override
	public String execute(Connection<?> connection) {
		// TODO Auto-generated method stub
		return connection.getKey().getProviderUserId();
	}

}
