package com.Handball.Analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyzerApplication.class, args);
	}



}
@RestController
class hello {
	@RequestMapping("/")
	String index(){
		return "Neu String";
	}
}
