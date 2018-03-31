package cn.yichao.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YiChaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YiChaoApplication.class, args);
	}
	@RequestMapping("/hello")
	public String hello_word() {
		return "hello";
	}
}