/**
 * 
 */
package com.itplayer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author zhailiang
 *
 */
@SpringBootApplication
//@RestController
//@EnableSwagger2
public class DemoApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {

		return "hello spring securityffff";
	}

}
