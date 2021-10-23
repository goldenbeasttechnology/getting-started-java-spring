package br.com.estudo.api.controller;

import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//to gerete tokens: http://jwtbuilder.jamiekurtz.com/
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE2MzQ5OTAwMzYsImV4cCI6MTc2MTIyMDQzNiwiYXVkIjoid3d3LnRlc3RlLmNvbSIsInN1YiI6IlRlc3RlIEpXVCIsImNoYXNzaSI6IjIzNDVNZWlhNzgiLCJjb250cmF0byI6IkExIiwiY3BmX2NucGoiOiIwMDAwMDAwMDE5MiIsImVtYWlsIjoidmluaUBjYXJyYXJhLmNvbS5iciJ9.r-GglavxS5KPZO_1kqGxGe7TwGTq0IjI4mMQyShLECE
//key: qwertyuiopasdfghjklzxcvbnm123456
@RestController
@RequestMapping(path = "/exemplo")
public class JWTReaderController {
	
	@GetMapping("/jwt")
	public ResponseEntity<String> greeting(@RequestHeader("jwt-token") String jwtToken) throws Exception {
	    // code that uses the language variable
		
		Base64.Decoder decoder = Base64.getDecoder();
		String[] headerPayloadSignature  = jwtToken.split("\\.");

		String header = new String(decoder.decode(headerPayloadSignature[0]));
		String payload = new String(decoder.decode(headerPayloadSignature[1]));
		System.out.println(header);
		System.out.println(payload);
		//transformar em objeto
		
	    return new ResponseEntity<String>(payload, HttpStatus.OK);
	}

}
