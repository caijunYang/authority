/**
 * 
 */
package com.itplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
	
//	@GetMapping("/hello")
	public String hello() {
		System.out.println("ddddd");
		return "hello spring security";
	}

}
