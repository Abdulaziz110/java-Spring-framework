package com.example.demo;

import com.example.demo.controllers.MyController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		MyController myConroller = (MyController) ctx.getBean("myController");
		String gnreating = myConroller.sayhello();
		System.out.println(gnreating);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
