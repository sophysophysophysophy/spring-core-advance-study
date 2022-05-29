package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Conifg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({ AppV1Config.class, AppV2Conifg.class })	//class를 스프링 빈으로 등록
//@Import(AppV1Config.class)	//class를 스프링 빈으로 등록
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}
