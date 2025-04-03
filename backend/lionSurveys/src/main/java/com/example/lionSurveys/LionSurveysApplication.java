package com.example.lionSurveys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ulisesbocchio.jasyptspringboot.annotation.*;

@SpringBootApplication(scanBasePackages = "com.example.lionSurveys")
@EnableEncryptableProperties
public class LionSurveysApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LionSurveysApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LionSurveysApplication.class, args);
	}

	private static Class<LionSurveysApplication> applicationClass = LionSurveysApplication.class;

}
