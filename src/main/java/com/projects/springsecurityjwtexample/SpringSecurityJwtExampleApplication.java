package com.projects.springsecurityjwtexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

import static com.projects.springsecurityjwtexample.constant.FileConstant.USER_FOLDER;


@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
		new File(USER_FOLDER).mkdirs();
	}

}
