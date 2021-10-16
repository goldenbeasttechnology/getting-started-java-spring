package br.com.estudo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/main")
public class HelloController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
    
}
