package com.ctscode.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@SpringBootApplication(scanBasePackages = {"com.ctscode.userinfo.repo", "com.ctscode.userinfo.service", "com.ctscode.userinfo.controller"})
//@ComponentScan
public class UserinformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserinformationApplication.class, args);
	}

}
