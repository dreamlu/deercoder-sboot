package com.wbkjcom.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer// 激活该应用为配置文件服务器：读取远程配置文件，转换为rest接口服务
@SpringBootApplication
@EnableEurekaClient
public class ConfigServerGitApplication {
	//启动项目后访问：http://localhost:1201/eureka-web/prod/master可查看到远程仓库配置文件信息
	//参考博客；http://blog.didispace.com/spring-cloud-starter-dalston-3/
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}
}