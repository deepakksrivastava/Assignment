package org.sample.auth;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.sample.auth.model.AccountRequest;
import org.sample.auth.service.AccountRequestService;
import org.sample.auth.service.impl.AccountRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Hello world!
 *
 */
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@SpringBootApplication
//@EnableJpaRepositories(basePackages = "org.sample.auth.dao")
@EnableAutoConfiguration
public class App {
	@Autowired
	private AccountRequestService accountRequestService;
	@RequestMapping(value="/authenticate", method=RequestMethod.GET)
	@ResponseBody
	String authenticateAccount(HttpServletRequest request, 
			@RequestHeader("userid")  String userid, 
			@RequestHeader("password")  String password ) throws Exception {
		String token=null;
		if(accountRequestService.getAccountRequest(userid).getPassword().equals(password))
		{
			//Random random = new SecureRandom();
			//token = new BigInteger(130, random).toString(32);
			token = Jwts.builder()
					  .setSubject("users/TzMUocMF4p")
					  .setExpiration(new Date(2017, 04, 22))
					  .claim("name", userid)
					  .claim("scope", "self groups/admins")
					  .signWith(
					    SignatureAlgorithm.HS256,
					    "secret".getBytes("UTF-8")
					  )
					  .compact();
		}
		else
		{
		throw new Exception("Authentication Failed.");
		}
		
		return token;
	}
	
	@RequestMapping(value="/refresh/token", method=RequestMethod.GET)
	@ResponseBody
	String refreshToken(HttpServletRequest request, 
	        @RequestParam(value="userID", required=true) String userid, 
	        @RequestParam(value="password", required=true) String password) {
		Random random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);
		return token;
	}
	
	@RequestMapping(value="/secure-resource", method=RequestMethod.GET)
	@ResponseBody
	String authorization(HttpServletRequest request, 
			@RequestHeader("Authorization")  String authZtoken) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		//AccountRequest accountRequest =new AccountRequest("u1","p1");
		//AccountRequestServiceImpl accountRequestServiceImpl = new AccountRequestServiceImpl();
		//accountRequestService.create(accountRequest);
		String jwt = authZtoken;
		Jws<Claims> claims = Jwts.parser()
		  .setSigningKey("secret".getBytes("UTF-8"))
		  .parseClaimsJws(jwt);
		String scope = (String) claims.getBody().get("scope");
		//if(accountRequestService.getAccountRequest(userid))
		//{
			
		//}
		//assertEquals(scope, "self groups/admins");
		return scope;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		// System.out.println( "Hello World!" );
	}
}
